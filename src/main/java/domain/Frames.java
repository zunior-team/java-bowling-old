package domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Frames {
    public static final int MAX_FRAME_COUNT = 10;
    private List<Frame> frames;

    private Frames() {
        final List<Frame> frames = Stream.generate(NormalFrame::newInstance)
                .limit(MAX_FRAME_COUNT - 1)
                .collect(Collectors.toList());

        frames.add(FinalFrame.newInstance());
        this.frames = Collections.unmodifiableList(frames);
    }

    public static Frames newInstance() {
        return new Frames();
    }

    public boolean isEnd() {
        return this.frames.stream()
                .allMatch(Frame::isDone);
    }

    public void throwBowlingBall(int inputFallenPins) {
        final Frame proceedFrame = this.frames.stream()
                .filter(frame -> !frame.isDone())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("you can not throw more"));
        proceedFrame.throwBowlingBall(inputFallenPins);
    }

    public List<Frame> getFrames() {
        return Collections.unmodifiableList(new ArrayList<>(this.frames));
    }

}
