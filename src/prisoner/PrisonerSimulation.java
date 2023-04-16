package prisoner;

import mvc.AppPanel;
import mvc.Model;
import mvc.Utilities;
import simstation.SimStationFactory;
import simstation.Simulation;
import simstation.SimulationPanel;

public class PrisonerSimulation extends Simulation {

    private final int SIZE = 20;

    private int coopStratSize;
    private int cheatStratSize;
    private int randomStratSize;
    private int ti4tatStratSize;

    public PrisonerSimulation() {
        super();
        coopStratSize = 0;
        cheatStratSize = 0;
        randomStratSize = 0;
        ti4tatStratSize = 0;
    }

    public void populate() {

        Prisoner prisoner = new Prisoner();

        for(int i = 0; i < SIZE; i++) {

            switch (Utilities.rng.nextInt(4)) {

                case 0:
                    prisoner = new Prisoner();
                    prisoner.setStrat(new AlwaysCooperate(prisoner));
                    add(prisoner);
                    coopStratSize++;
                    break;
                case 1:
                    prisoner = new Prisoner();
                    prisoner.setStrat(new AlwaysCheat(prisoner));
                    add(prisoner);
                    cheatStratSize++;
                    break;
                case 2:
                    prisoner = new Prisoner();
                    prisoner.setStrat(new RandomlyCooperate(prisoner));
                    add(prisoner);
                    randomStratSize++;
                    break;
                case 3:
                    prisoner = new Prisoner();
                    prisoner.setStrat(new Tit4Tat(prisoner));
                    add(prisoner);
                    ti4tatStratSize++;
                    break;

            }

        }

    }

    @Override
    public void stats() {

        String forReturn = "";

        double coopAverage = 0, cheatAverage = 0, randomAverage = 0, tit4tatAverage = 0;

        for(int i = 0; i < SIZE; i++) {

            Prisoner prisoner = (Prisoner) getAgents().get(i);

            if(prisoner.getStrat().getClass().equals((new AlwaysCooperate(prisoner)).getClass())) {
                coopAverage += prisoner.getFitness();
            } else if(prisoner.getStrat().getClass().equals((new AlwaysCheat(prisoner)).getClass())) {
                cheatAverage += prisoner.getFitness();
            } else if(prisoner.getStrat().getClass().equals((new RandomlyCooperate(prisoner)).getClass())) {
                randomAverage += prisoner.getFitness();
            } else if(prisoner.getStrat().getClass().equals((new Tit4Tat(prisoner)).getClass())) {
                tit4tatAverage += prisoner.getFitness();
            }

        }

        Utilities.inform(   "#agents = " + getAgents().size() + "\nclock = " + clock + "\n" +
                            "Cooperate Strategy size = " + coopStratSize + "\n" +
                            "Always Cooperate Strategy Average = " + coopAverage + "\n" +
                            "Cheat Strategy size = " + cheatStratSize + "\n" +
                            "Always Cheat Strategy Average = " + cheatAverage + "\n" +
                            "Randomly Cooperate Strategy size = " + randomStratSize + "\n" +
                            "Randomly Cooperate Strategy Average = " + randomAverage + "\n" +
                            "Tit4Tat Strategy size = " + ti4tatStratSize + "\n" +
                            "Tit4Tat Strategy Average = " + tit4tatAverage);

    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new prisonerFactory());
        panel.display();
    }

}

class prisonerFactory extends SimStationFactory {

    public Model makeModel() { return new PrisonerSimulation(); }
    public String getTitle() { return "Prisoner"; }

}
