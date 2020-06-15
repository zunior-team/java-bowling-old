package bowling;

public class BowlingPin {

    private boolean isOverTurn = false;

    public BowlingPin(){}

    public boolean isAlive(){
        return !isOverTurn;
    }

    public void overturn(){
        this.isOverTurn = true;
    }
}
