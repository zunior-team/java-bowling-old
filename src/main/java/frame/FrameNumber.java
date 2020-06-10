package frame;

public final class FrameNumber {

    private int frameIndex;

    public FrameNumber(final int number){
        this.frameIndex = number;
    }

    public int number(){
        return this.frameIndex;
    }
}
