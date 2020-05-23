package bowling.state;

import bowling.frame.Frame;
import bowling.pin.Pins;

public class Ready extends State {
    private static final Ready READY = new Ready();

    private Ready() {}

    public static Ready getInstance() {
        return READY;
    }

    @Override
    public void downPins(Frame frame, int numOfDownPins) {
        Pins pins = frame.getPins();

        pins.downPins(numOfDownPins);
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
