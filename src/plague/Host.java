/*
4/13/23 - Hazuki Sugahara: Created the file
4/14/23 - Hazuki Sugahara: Modified the file
*/

package plague;

import simstation.*;
import mvc.*;

public class Host extends Agent{
    
    private boolean infected = false;
    
    private final int resistence = 2;
    
    public Host() {
        super();
        heading = Heading.random();
        if(Utilities.rng.nextInt(100) < PlagueSimulation.VIRULENCE) 
            infected = true;
    }

    public boolean getInfected() {
        return infected;
    }
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        Host neighbor = (Host) simulation.getNeighbor(this, 10);
        if (neighbor != null) {
            if(neighbor.getInfected())
                if(Utilities.rng.nextInt(100) > resistence)
                    infected = true;
        }
        move(steps);
    }
}

