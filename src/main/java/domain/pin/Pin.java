package domain.pin;

public class Pin {

    public static final Pin STANDING = new Pin(true);
    private boolean isStanding;

    private Pin(boolean isStanding) {
        this.isStanding = isStanding;
    }


    public boolean isStanding() {
        return isStanding;
    }

    public void fall() {
        this.isStanding = false;
    }
}
