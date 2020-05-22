package bowling.state;

import bowling.frame.Frame;

public class Ready extends State {
    private static final Ready READY = new Ready();

    private Ready() {}

    public static Ready getInstance() {
        return READY;
    }

    @Override
    void internalProcess(Frame frame, int countOfFallenPins) {

    }

    @Override
    public void updateState(Frame frame) {
        if (frame.isPinLeft()) {
            frame.updateState(Playing.getInstance());
            return;
        }

        frame.updateState(Strike.getInstance());
    }
}
