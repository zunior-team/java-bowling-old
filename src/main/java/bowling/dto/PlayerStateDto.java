package bowling.dto;

import java.util.List;

public class PlayerStateDto {
    private String name;
    private List<StateDto> states;

    public String getName() {
        return name;
    }

    public List<StateDto> getStates() {
        return states;
    }
}
