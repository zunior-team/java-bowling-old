package board;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

final class ScoreSnapshot {

    private final List<String> snapshot;

    private ScoreSnapshot(final List<String> snapshot){
        this.snapshot = snapshot;
    }

    static ScoreSnapshot createSnapShotByName(final String name){
        return new ScoreSnapshot(Collections.singletonList(name));
    }

    static ScoreSnapshot createSnapShotEmpty(final int round){
        return new ScoreSnapshot(new ArrayList(){{ add(StringUtils.EMPTY); }});
    }

    Stream<String> toStream(){
        return Stream.of(String.join(StringUtils.EMPTY, snapshot));
    }

    public void add(final String score){
        this.removeFirstEmptySnapshotIfExist();
        snapshot.add(score);
    }

    private void removeFirstEmptySnapshotIfExist(){
        if(StringUtils.EMPTY.equals(snapshot.get(0))){
            snapshot.remove(0);
        }
    }

    static class SnapshotConstant{
        static final String SPACE_EMPTY_FORMAT = "%1s";
        static final String SCORE_EMPTY_FORMAT = "%3s";
        static final String NAME_FORMAT = "%4s";
        static final String NEXT = "|";
        private SnapshotConstant(){}
    }
}
