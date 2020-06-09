package model;

import frame.FrameNumber;

public class Round {
    private final int round;

    public Round(final int round){
        this.round = round;
    }

    public int getRound(){
        return round;
    }

    public FrameNumber toFrameNumber(){
        return new FrameNumber(round);
    }
}
