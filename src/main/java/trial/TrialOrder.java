package trial;

import bowling.BowlingPins;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public enum TrialOrder {
    FIRST, SECOND, THIRD;

    private static final Map<TrialOrder, TrialOrder> nextTrial = new HashMap<>();
    private static final Map<Trial, TrialResultType> resultTypeSet = new HashMap<>();

    static {
        initResultTypeSet();
        initNextTrial();
    }

    static void initResultTypeSet(){
        IntStream.rangeClosed(0, 10)
                .mapToObj(Trial::createByFirst)
                .forEach(trial -> resultTypeSet.put(trial, trial.getResultType()));

        IntStream.rangeClosed(0, 10)
                .mapToObj(Trial::createBySecond)
                .forEach(trial -> resultTypeSet.put(trial, trial.getResultType()));

        IntStream.rangeClosed(0, 10)
                .mapToObj(Trial::createByThird)
                .forEach(trial -> resultTypeSet.put(trial, trial.getResultType()));
    }

    static void initNextTrial(){
        nextTrial.put(FIRST, SECOND);
        nextTrial.put(SECOND, THIRD);
    }

    public static TrialResultType getTrialResultType(final TrialOrder order, final int alivePins) {
        return resultTypeSet.get(Trial.create(order, alivePins));
    }

    public TrialOrder next() {
        return nextTrial.get(this);
    }

    public BowlingPins getBonusBowlingPinsIfPossible(final BowlingPins bowlingPins){
        if(this == THIRD){
            return new BowlingPins();
        }

        if(this == SECOND && bowlingPins.isAllDeadPins()){
            return new BowlingPins();
        }

        return bowlingPins;
    }
}
