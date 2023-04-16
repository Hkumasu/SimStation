package prisoner;

import mvc.Utilities;

public class RandomlyCooperate extends Strat {

    public RandomlyCooperate(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public Boolean useStrat(Boolean gotCheatedOnLastTime) {

        switch (Utilities.rng.nextInt(2)) {
            case 0: stratReturn = false; break;
            case 1: stratReturn = true; break;
        }
        return stratReturn;

    }

}
