package prisoner;

public class AlwaysCooperate extends Strat {

    public AlwaysCooperate(Prisoner prisoner) {
        super(prisoner);
        stratReturn = true;
    }

    @Override
    public Boolean useStrat(Boolean gotCheatedOnLastTime) {
        return stratReturn;
    }

}
