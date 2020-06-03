package domain.pin;

public class Pin {


    private boolean isStanding;

    private Pin(boolean isStanding) {
        this.isStanding = isStanding;
    }

    public static Pin newStandingPin() {
        return new Pin(true);
    }


    public boolean isStanding() {
        return isStanding;
    }

    public void fall() {
        this.isStanding = false;
    }
}
