package player;

import board.BowlingBoard;
import exception.player.PlayerCreateException;
import frame.BowlingFrames;
import overturn.OverturnScore;
import trial.TrialResultType;

import java.util.Objects;

import static player.PlayerConstant.MAXIMUM_NAME_LENGTH;
import static player.PlayerConstant.MINIMUM_NAME_LENGTH;

public class Player {

    private final String name;
    private final BowlingFrames bowlingFrames;
    private final BowlingBoard bowlingBoard;

    private Player(final String name){
        verifyPlayerName(name);
        this.name = name;
        this.bowlingFrames = BowlingFrames.create();
        this.bowlingBoard = bowlingFrames.getBowlingStatusByName(name);
    }

    public static Player create(final String name){
        return new Player(Objects.requireNonNull(name, "플레이어의 이름은 널이 될 수 없습니다."));
    }

    private void verifyPlayerName(final String name){
        assert name != null;

        if(name.length() < MINIMUM_NAME_LENGTH
                || name.length() > MAXIMUM_NAME_LENGTH){
            throw new PlayerCreateException("플레이어의 이름은 세자리를 초과하거나 공백이 될 수 없습니다.");
        }
    }

    public BowlingBoard getBowlingBoard(){
        return this.bowlingBoard;
    }

    public int playBowlingForRound(final OverturnScore overturnScore){
        final TrialResultType resultType = bowlingFrames.overturn(overturnScore);

    }
}
