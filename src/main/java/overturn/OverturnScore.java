package overturn;

import exception.overturnscore.OverturnScoreCreateException;

import static overturn.OverturnScoreConstant.MAX_PIN_COUNT;

public class OverturnScore {

    private final int overturnPins;

    public OverturnScore(final int overturnPins){
        verifyOverturnPins(overturnPins);
        this.overturnPins = overturnPins;
    }

    private void verifyOverturnPins(final int overturnPins){
        if(overturnPins < 0){
            throw new OverturnScoreCreateException("넘어트린 핀의 개수가 음수가 될 수 없습니다.");
        }

        if(overturnPins > MAX_PIN_COUNT){
            throw new OverturnScoreCreateException("넘어트린 핀의 개수가 최대 핀의 개수를 넘을 수 없습니다.");
        }
    }

    public int getOverturnPins() {
        return overturnPins;
    }

    public boolean isOverturnZero(){
        return overturnPins == 0;
    }
}
