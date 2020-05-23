package bowling.state;

import bowling.frame.Frame;
import bowling.pin.Pins;

public class Playing extends State {
    private static final Playing PLAYING = new Playing();

    private Playing() {}

    public static Playing getInstance() {
        return PLAYING;
    }

    @Override
    public void downPins(Frame frame, int numOfDownPins) {
        Pins pins = frame.getPins();
        pins.downLeftPins(numOfDownPins);
    }
}
