/*
4/13/23 - Hazuki Sugahara: Created the file
*/

package plague;

import simstation.*;
import mvc.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; //% chance of infection

    public void populate() {
        for(int i = 0; i < 40; i++) {
            add(new Host());
        }
    }

    public void stats() {
        double percentInfected;
        int numInfected = 0;
        List<Agent> agents = this.getAgents();
        Host host;
        for(Agent a: agents) {
            host = (Host) a;
            if(host.getInfected())
                numInfected++;
        }
        percentInfected = numInfected / agents.size() * 100;

        Utilities.inform("#agents = " + agents.size() + "\n" + "clock = " + clock + "\n" +
                "#% infected = " + percentInfected);
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }
}

class PlagueFactory extends SimStationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
}
