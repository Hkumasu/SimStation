package prisoner;

import java.util.ArrayList;

public class Tit4Tat extends Strat {

    public Tit4Tat(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public Boolean useStrat(ArrayList<Boolean> history) {

        // check if array list is still empty before accessing array out of bounds
        if(history.size() == 0)
            return false;

        if(history.get(history.size() - 1)) {
            stratReturn = true;
        } else {
            stratReturn = false;
        }
        return stratReturn;

    }
}
