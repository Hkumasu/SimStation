package prisoner;

import mvc.Utilities;

import java.util.ArrayList;

public class RandomlyCooperate extends Strat {

    public RandomlyCooperate(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public Boolean useStrat(ArrayList<Boolean> history) {

        switch (Utilities.rng.nextInt(2)) {
            case 0: stratReturn = false; break;
            case 1: stratReturn = true; break;
        }
        return stratReturn;

    }

}
