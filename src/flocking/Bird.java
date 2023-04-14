/*
4/13/2023 - Hazuki Sugahara: Created the file
*/

package flocking;

import mvc.*;
import simstation;
import java.util.List;

public class FlockingSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 15; i++)
            add(new Bird());
    }

    public void stats() {
        int speed1 = 0, speed2 = 0, speed3 = 0, speed4 = 0, speed5 = 0, speed = 0;
        List<Agent> agents = this.getAgents();
        for(Agent a: agents) {
            speed = a.getSpeed();
            switch (speed) {
                case 1: speed1++;
                break;
                case 2: speed2++;
                break;
                case 3: speed3++;
                break;
                case 4: speed4++;
                break;
                case 5: speed5++;
                break;
            }
        }

        Utilities.inform("#birds @ speed 1 = " + speed1 + "\n" + "#birds @ speed 2 = " + speed2 + "\n" +
                "#birds @ speed 3 = " + speed3 + "\n" + "#birds @ speed 4 = " + speed4 + "\n" + "#birds @ speed 5 = " + speed5);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }
}

class FlockingFactory extends SimStationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking"; }
}
