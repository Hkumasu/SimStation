package prisoner;

import java.util.ArrayList;

public abstract class Strat {

    private Prisoner prisoner;
    protected boolean stratReturn;

    public Strat(Prisoner prisoner) {
        this.prisoner = prisoner;
    }

    public abstract Boolean useStrat(ArrayList<Boolean> history);

}
