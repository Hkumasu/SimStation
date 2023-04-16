package prisoner;

import java.util.ArrayList;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;
import simstation.Simulation;
import simstation.StatsCommand;

public class Prisoner extends Agent {

    private int fitness = 0;
    private Strat strat;
    private Boolean gotCheatedOnLastTime;

    public Prisoner() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(10) + 1;
        gotCheatedOnLastTime = false;
    }

    public void setGotCheatedOnLastTime(Boolean gotCheatedOnLastTime) {
        this.gotCheatedOnLastTime = gotCheatedOnLastTime;
    }

    public Boolean getGotCheatedOnLastTime() {
        return gotCheatedOnLastTime;
    }

    @Override
    public void update() {

    }
}
