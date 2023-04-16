package prisoner;

import java.util.ArrayList;

public class AlwaysCheat extends Strat {

    public AlwaysCheat(Prisoner prisoner) {
        super(prisoner);
        stratReturn = false;
    }

    @Override
    public Boolean useStrat(ArrayList<Boolean> history) {
        return stratReturn;
    }

}
