package frame;

import java.util.List;

public class FrameNumber {

    private int currentNumber;

    FrameNumber(final int number){
        this.currentNumber = number;
    }

    void increaseFrameNumber(){
        currentNumber++;
    }

    BowlingFrame getCurrentBowlingFrame(final List<BowlingFrame> bowlingFrames){
        return bowlingFrames.get(currentNumber);
    }
}
