/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file and still modifiying
4/11/23 - Hazuki Sugahara: Added statments for agents list and deleted the point class
*/

package simstation;

import mvc.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Simulation extends Model{
    int clock = 0;
    private Point location;
    private List<Point>path;
    private List<Agent> agents;

    public static Integer windowSize = 250;

    public Simulation() {
        agents = new LinkedList<Agent>();
    }

 //   public Point getLocation()  { return location;}
 //   public Iterator<Point> iterator() { return path.iterator(); }
    
    public void add(Agent a) {
        agents.add(a);
        a.setSimulation(this);
    }

    public void start() {
        populate();
        for(Agent a: agents) {
            Thread thread = new Thread(a);
            thread.start();
        } 
        startTimer();
    }

    public void suspend() {
        stopTimer();
        for(Agent a: agents) {
            a.suspend();
        }
    }

    public void resume() {
        startTimer();
        for(Agent a: agents) {
            a.resume();
        }
    }

    public void populate() {
        //will declared in subclass
    }

    public void stop() {
        stopTimer();
        for(Agent a: agents) {
            a.stop();
        }
    }
    
    public void stats() {
        Utilities.inform();
    }

    public Agent getneightbor(Agent a, double radius) {
        int startIndex = (int) (Math.random() * agents.size()); // random starting index for location
        int index = startIndex;
        do { //finds neighboring agent
            Agent a2 = agents.get(index);
            double distance = Math.sqrt(Math.pow(a.getXc() - a2.getXc(), 2) + Math.pow(a.getYc() - a2.getYc(), 2));
            if (a != a2 && distance <= radius) {
                return a2;
            }
            index = (index + 1) % agents.size(); // moves to the next agent in the list
        } while (index != startIndex); // loop until we get back to the starting index
        return null; // when no neighbor is found
    }
    
    
    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ClockUpdater(), 100, 100);
    }
    
    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }
    
    private class ClockUpdater extends TimerTask {
        public void run() {
            clock++;
            changed();
        }
}
