/*
4/13/23 - Hazuki Sugahara: Created the file
*/

package plague;

import simstation.*;
import mvc.*;

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; //% chance of infection
    public static int RESISTANCE = 2; //% chance of resisting infection
//     List<Host> agents;

    public void populate() {
        for(int i = 0; i < 50; i++)
            add(new Host());
        //agents.add(new Host());
    }

    public void stats() {
        double percentInfected;
        int numInfected = 0;
        for(Person a: agents) {
            if(a.getInfected())
                numInfected++;
        }
        percentInfected = numInfected / agents.size() * 100;

        Utilities.inform("#agents = " + agents.size() + "\n" + "clock = " + clock + "\n" +
                "#% infected = " + percentInfected);
    }
}

class PlagueFactory extends SimStationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague";}
}
