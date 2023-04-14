/*
4/4/23 - Hazuki Sugahara: Created the file
4/6/23 - Hazuki Sugahara: Modified the file and still modifiying
4/11/23 - Hazuki Sugahara: Added statments for agents list and deleted the point class
4/11/23 - Jelinne Ramos: Added getNeighbor and stats method 
4/13/23 - Jelinne Ramos: added methods for the timer
4/13/23 - Hazuki Sugahara: Deleted point and getLocation method. Clear Agents when stop is pushed
*/

package simstation;

import mvc.*;
import java.io.Serializable;
import java.util.*;

public class Simulation extends Model{
    int clock = 0;
    private List<Agent> agents;
    transient private Timer timer;

    public static Integer windowSize = 250;

    public Simulation() {
        agents = new LinkedList<Agent>();
    }
    
    public void add(Agent a) {
        agents.add(a);
        a.setSimulation(this);
    }
    
    public List<Agent> getAgents() {
        return agents;
    }

    public void start() {
        agents.clear();
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
        clock = 0;
    }
    
    public void stats() {
        Utilities.inform("#agents = " + getAgents().size() + "\nclock = " + clock);
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
