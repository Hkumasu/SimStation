package prisoner;

public class AlwaysCheat extends Strat {

    public AlwaysCheat(Prisoner prisoner) {
        super(prisoner);
        stratReturn = false;
    }

    @Override
    public Boolean useStrat(Boolean gotCheatedOnLastTime) {
        return stratReturn;
    }

}
