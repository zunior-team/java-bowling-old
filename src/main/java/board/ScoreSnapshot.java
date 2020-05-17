package board;

import org.apache.commons.lang3.StringUtils;
import trial.TrialResultType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static board.ScoreSnapshot.SnapshotConstant.*;

final class ScoreSnapshot {

    private final List<String> snapshot;

    private ScoreSnapshot(final List<String> snapshot){
        this.snapshot = snapshot;
    }

    static ScoreSnapshot createSnapShotByName(final String name){
        return new ScoreSnapshot(Collections.singletonList(String.format(NAME_FORMAT, name)));
    }

    static ScoreSnapshot createSnapShotEmpty(final int round){
        return new ScoreSnapshot(new ArrayList(){{ add(String.format(SCORE_EMPTY_FORMAT, StringUtils.EMPTY)); }});
    }

    Stream<String> toStream(){
        return Stream.of(String.join(StringUtils.EMPTY, snapshot));
    }

    public ScoreSnapshot add(final String element){
        snapshot.add(element);
        return this;
    }

    public ScoreSnapshot addNextIfResultProgress(final TrialResultType resultType){
        if(!resultType.isProgress()){
            return this;
        }
        snapshot.add(NEXT);
        return this;
    }

    public void removeEmptySnapshotIfExist(){
        if(String.format(SCORE_EMPTY_FORMAT, StringUtils.EMPTY).equals(snapshot.get(0))){
            snapshot.remove(0);
        }
    }

    static class SnapshotConstant{
        static final String SCORE_EMPTY_FORMAT = "%3s";
        static final String NAME_FORMAT = "%4s";
        static final String NEXT = "|";
        private SnapshotConstant(){}
    }
}
