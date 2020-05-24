package bowling.dto;

import bowling.player.Player;

import java.util.List;
import java.util.stream.Collectors;

public class PlayerStateDto {
    private final String name;
    private final int curFrameNo;
    private final List<StateDto> states;

    private PlayerStateDto(final Player player) {
        this.name = player.getName();
        this.states = player.getStates()
                .stream()
                .map(StateDto::of)
                .collect(Collectors.toList());
        this.curFrameNo = states.size();
    }

    public static PlayerStateDto of(final Player player) {
        return new PlayerStateDto(player);
    }

    public String getName() {
        return name;
    }

    public int getCurFrameNo() {
        return curFrameNo;
    }

    public List<StateDto> getStates() {
        return states;
    }
}
