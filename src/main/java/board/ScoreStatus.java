package board;

import exception.board.ScoreStatusCreateException;
import frame.BowlingFrame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static player.PlayerConstant.MAXIMUM_NAME_LENGTH;
import static player.PlayerConstant.MINIMUM_NAME_LENGTH;

public class ScoreStatus {

    private List<ScoreSnapshot> scoreStatus = new ArrayList<>();

    public ScoreStatus(final String name, final List<BowlingFrame> bowlingFrames){
        verifyPlayerName(name);
        verifyBowlingFrames(bowlingFrames);

        scoreStatus.add(ScoreSnapshot.createSnapShotByName(name));
        scoreStatus.addAll(IntStream.range(1, bowlingFrames.size())
                .mapToObj(ScoreSnapshot::createSnapShotEmpty)
                .collect(Collectors.toList()));
    }

    private void verifyPlayerName(final String name){
        Objects.requireNonNull(name, "플레이어의 이름은 널이 될 수 없습니다.");

        if(name.length() < MINIMUM_NAME_LENGTH
                || name.length() > MAXIMUM_NAME_LENGTH){
            throw new ScoreStatusCreateException("플레이어의 이름은 세자리를 초과하거나 공백이 될 수 없습니다.");
        }
    }

    private void verifyBowlingFrames(final List<BowlingFrame> bowlingFrames) {
        Objects.requireNonNull(bowlingFrames, "볼링 점수 목록은 널이 될 수 없습니다.");

        if(bowlingFrames.size() < 10){
            throw new ScoreStatusCreateException("볼링 점수 프레임의 크기가 10 미만이기 때문에 점수 현황판을 생성할 수 없습니다.");
        }
    }

    public List<String> getScoreStatus() {
        return Collections.unmodifiableList(scoreStatus.stream()
                .flatMap(ScoreSnapshot::toStream)
                .collect(Collectors.toList()));
    }

    public ScoreSnapshot fillScoreByFrameNumber(final int frameNumber){
        return scoreStatus.get(frameNumber);
    }
}
