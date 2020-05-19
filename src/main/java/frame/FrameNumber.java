package frame;

import trial.TrialResultType;

import java.util.List;
import java.util.Objects;

public final class FrameNumber {

    private int frameIndex;

    FrameNumber(final int number){
        this.frameIndex = number;
    }

    void increaseByTrialType(final TrialResultType currentResultType){
        frameIndex = (currentResultType.isProgress() || currentResultType.isBonus())
                ? frameIndex
                : frameIndex + 1;
    }

    BowlingFrame getCurrentBowlingFrame(final List<BowlingFrame> bowlingFrames){
        return bowlingFrames.get(frameIndex);
    }

    FrameNumber newInstance(){
        return new FrameNumber(frameIndex);
    }

    public int get() {
        return this.frameIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrameNumber that = (FrameNumber) o;
        return frameIndex == that.frameIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(frameIndex);
    }
}
