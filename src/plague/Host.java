package plague;

import simstation.*;
import mvc.*;

public class Host extends Agent{
    private boolean infected;
    private int resistence = 2;
  
    public Host() {
        super();
        heading = Heading.random();
        if(Utilities.rng.nextInt(100) < PlagueSimulation.VIRULENCE) {
            this.infected = true;
        }
        this.infected = false;
    }

    public boolean getInfected() {
        return infected;
    }
  
    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        Agent neighbor = simulation.getneightbor(this, 10); //should make Host neighbor
        if (neighbor != null) {
            if(neighbor.getInfected()) //doesn't work
                if(Utilities.rng.nextInt(100) < resistence)
                    infected = true;

        }
        move(steps);
    }
}
