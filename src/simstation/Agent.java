/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: copied the agentlab and modifiying for simstation
*/

package simstation;

import mvc.*;
import java.io.Serializable;


abstract class Agent implements Serializable, Runnable {
  protected String name;
    protected Thread myThread;
    private boolean suspended, stopped;
    protected Simulation Simulation;

    public Agent(String name) {
        this.name = name;
        suspended = false;
        stopped = false;
        myThread = null;
    }

    public void setSimulation(Simulation s) { Simulation = s; }
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
}
