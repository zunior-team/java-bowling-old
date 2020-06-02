package domain.pin;

public class Pin {
    private boolean isStanding = true;

    public boolean isStanding() {
        return isStanding;
    }

    public void fall() {
        this.isStanding = false;
    }
}
