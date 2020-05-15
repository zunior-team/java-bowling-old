package board;

import org.apache.commons.lang3.StringUtils;
import trial.TrialResultType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

final class ScoreSnapshot {

    private static final String SCORE_EMPTY_FORMAT = "%2s";
    private static final String NAME_FORMAT = "%4s";
    private final List<String> snapshot;

    private ScoreSnapshot(final List<String> snapshot){
        this.snapshot = snapshot;
    }

    static ScoreSnapshot createSnapShotByName(final String name){
        return new ScoreSnapshot(Collections.singletonList(String.format(NAME_FORMAT, name)));
    }

    static ScoreSnapshot createSnapShotEmpty(final int round){
        return new ScoreSnapshot(Arrays.asList(String.format(SCORE_EMPTY_FORMAT, StringUtils.EMPTY)));
    }

    Stream<String> toStream(){
        return snapshot.stream();
    }

    public void fillScoreByResult(TrialResultType trialResultType){
        trialResultType.isProgress()
    }

    private void addStrike(){

    }

    private void addGutter(){

    }

    private void add
}
