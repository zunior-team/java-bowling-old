package frame;

import trial.TrialResultType;

import java.util.List;
import java.util.Objects;

public final class FrameNumber {

    private int currentNumber;

    FrameNumber(final int number){
        this.currentNumber = number;
    }

    void increaseByTrialType(final TrialResultType currentResultType){
        currentNumber = (currentResultType.isProgress())
                ? currentNumber
                : currentNumber + 1;
    }

    BowlingFrame getCurrentBowlingFrame(final List<BowlingFrame> bowlingFrames){
        return bowlingFrames.get(currentNumber);
    }

    FrameNumber newInstance(){
        return new FrameNumber(currentNumber);
    }

    public int get() {
        return this.currentNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNumber that = (FrameNumber) o;
        return currentNumber == that.currentNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentNumber);
    }
}
