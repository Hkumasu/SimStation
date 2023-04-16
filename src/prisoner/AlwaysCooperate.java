package prisoner;

import java.util.ArrayList;

public class AlwaysCooperate extends Strat {

    public AlwaysCooperate(Prisoner prisoner) {
        super(prisoner);
        stratReturn = true;
    }

    @Override
    public Boolean useStrat(ArrayList<Boolean> history) {
        return stratReturn;
    }

}
