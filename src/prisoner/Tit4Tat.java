package prisoner;

public class Tit4Tat extends Strat {
    public Tit4Tat(Prisoner prisoner) {
        super(prisoner);
    }

    @Override
    public Boolean useStrat(Boolean gotCheatedOnLastTime) {
        
        if(gotCheatedOnLastTime) {
            stratReturn = true;
        } else {
            stratReturn = false;
        }
        return stratReturn;

    }
}
