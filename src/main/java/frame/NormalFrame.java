package frame;

import bowling.BowlingPins;
import exception.overturnscore.OverturnMissCountPinsException;
import overturn.OverturnScore;

public class NormalFrame implements BowlingFrame{

    private final BowlingPins bowlingPins;
    private final Trial trial;

    public NormalFrame(){
        bowlingPins = new BowlingPins();
        trial = new Trial();
    }

    @Override
    public void decreasePins(final OverturnScore overturnScore){
        final int overturnPins = overturnScore.getOverturnPins();
        final int alivePins = bowlingPins.getAlivePinsCount();

        if(overturnPins > alivePins){
            throw new OverturnMissCountPinsException(alivePins, overturnPins);
        }


    }
}
