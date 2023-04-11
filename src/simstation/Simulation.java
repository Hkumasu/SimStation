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
        for(Agent a: agents) {
            Thread thread = new Thread(a);
            thread.start();
        }
    }

    public void suspend() {
        for(Agent a: agents) {
            a.suspend();
        }
    }

    public void resume() {
        for(Agent a: agents) {
            a.resume();
        }
    }

    public void populate() {
        //will declared in subclass
    }

    public void stop() {
        for(Agent a: agents) {
            a.stop();
        }
    }

    public Agent getneightbor(Agent a, double radius) {
        //need some statement
    }
}
