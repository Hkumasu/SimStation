package prisoner;

import java.util.ArrayList;

import mvc.Utilities;
import simstation.Agent;
import simstation.Heading;

public class Prisoner extends Agent {

    private int fitness = 0;
    private Strat strat;
    private ArrayList<Boolean> history;

    // final variables for points
    private final int COOPERATEWIN = 3;
    private final int COOPERATELOSE = 0;
    private final int CHEATWIN = 5;
    private final int CHEATLOSE = 1;

    public Prisoner() {
        super();
        heading = Heading.random();
        speed = Utilities.rng.nextInt(10) + 1;
        this.strat = null;
        history = new ArrayList<Boolean>();
    }

    public ArrayList<Boolean> getHistory() {
        return history;
    }

    public Strat getStrat() {
        return strat;
    }

    public void setStrat(Strat strat) {
        this.strat = strat;
    }

    private Boolean strategy() {
        return strat.useStrat(getHistory());
    }

    public void fitnessInc(int fitness) {
        this.fitness += fitness;
    }

    public int getFitness() {
        return fitness;
    }

    public void trade(Prisoner neighbor) {

        Boolean prisonerStrat1 = strategy();
        Boolean prisonerStrat2 = neighbor.strategy();

        if(!prisonerStrat1 && prisonerStrat2) {
            fitnessInc(CHEATWIN);
            neighbor.fitnessInc(COOPERATELOSE);
        } else if(prisonerStrat1 && prisonerStrat2) {
            fitnessInc(COOPERATEWIN);
            neighbor.fitnessInc(COOPERATEWIN);
        } else if(prisonerStrat1) {
            fitnessInc(COOPERATELOSE);
            neighbor.fitnessInc(CHEATWIN);
        } else {
            fitnessInc(CHEATLOSE);
            neighbor.fitnessInc(CHEATLOSE);
        }

        addHistory(prisonerStrat2);
        neighbor.addHistory(prisonerStrat1);

    }

    public void addHistory (Boolean tradeRes){
        history.add(tradeRes);
    }

    @Override
    public void update() {

        PrisonerSimulation prison = (PrisonerSimulation) simulation;
        Prisoner neighbor = (Prisoner) prison.getNeighbor(this, 5);

        if(neighbor != null)
            trade(neighbor);

        heading = Heading.random();
        speed = random.nextInt(10);

        move(speed);

        simulation.changed();

    }

}