/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: copied the agentlab and modifiying for simstation
4/8/23 - Rohith Iyengar: added the move method and x,y coordinates
*/

package simstation;

import java.io.Serializable;
import java.util.Random;

abstract class Agent implements Serializable, Runnable {
  protected String name;

    protected Heading heading;
    protected Thread myThread;
    private boolean suspended, stopped;
    protected Simulation simulation;

    protected Random random = new Random();

    protected int xc;
    protected int yc;

    public Agent(String name) {
        this.name = name;
        suspended = false;
        stopped = false;
        myThread = null;

        this.xc = random.nextInt(simulation.windowSize);
        this.yc = random.nextInt(simulation.windowSize);
    }

    public void setSimulation(Simulation s) { simulation = s; }
    public String getName() { return name; }
    public synchronized String toString() {
        String result = name;
        if (stopped) result += " (stopped)";
        else if (suspended) result += " (suspended)";
        else result += " (running)";
        return result;
    }
    // thread stuff:
    public synchronized void stop() { stopped = true; }
    public synchronized boolean isStopped() { return stopped; }
    public synchronized void suspend() { suspended = true; }
    public synchronized boolean isSuspended() { return suspended;  }
    public synchronized void resume() { notify(); }
    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getXc() {
        return xc;
    }

    public Integer getYc() {
        return yc;
    }

    public void run() {
        myThread = Thread.currentThread();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(1000);
                checkSuspended();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void update();

    public void move(int steps) {
        switch(heading)
        {
            case NORTH:
            {
                if(yc - steps < 0)
                {
                    yc = simulation.windowSize + (yc - steps);
                }
                yc -= steps;
                break;
            }
            case SOUTH:
            {
                if(yc + steps > simulation.windowSize)
                {
                    yc = simulation.windowSize - steps;
                }
                yc += steps;
                break;
            }
            case EAST:
            {
                if(xc + steps > simulation.windowSize)
                {
                    xc = simulation.windowSize - steps;
                }
                xc += steps;
                break;
            }
            case WEST:
            {
                if(xc - steps < 0)
                {
                    xc = simulation.windowSize - (xc - steps);
                }
                xc -= steps;
                break;
            }
        }
        simulation.changed();
    }


}