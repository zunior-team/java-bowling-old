package board;

import exception.board.ScoreStatusCreateException;
import frame.BowlingFrame;
import org.apache.commons.lang3.StringUtils;
import score.ScoreType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static player.PlayerConstant.MAXIMUM_NAME_LENGTH;
import static player.PlayerConstant.MINIMUM_NAME_LENGTH;

public class ScoreStatus {

    private List<String> scoreStatus = new ArrayList<>();

    public ScoreStatus(final String name, final List<BowlingFrame> bowlingFrames){
        verifyPlayerName(name);
        scoreStatus.add(name);
        scoreStatus.addAll(
                IntStream.rangeClosed(1, bowlingFrames.size())
                        .mapToObj(round -> StringUtils.EMPTY)
                        .collect(Collectors.toList()));
    }

    private void verifyPlayerName(final String name){
        assert name != null;

        if(name.length() < MINIMUM_NAME_LENGTH
                || name.length() > MAXIMUM_NAME_LENGTH){
            throw new ScoreStatusCreateException("플레이어의 이름은 세자리를 초과하거나 공백이 될 수 없습니다.");
        }
    }

    public List<String> getScoreStatus() {
        return Collections.unmodifiableList(scoreStatus);
    }

    public void addScoreByRound(final ScoreType scoreType, final BowlingFrame bowlingFrame){

    }
}
