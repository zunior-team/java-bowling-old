package com.zuniorteam.bowling;

        import com.zuniorteam.bowling.core.user.User;
        import com.zuniorteam.bowling.core.value.PinSize;

public class InputRender {
    public static User getUser(String username) {
        return new User(username);
    }

    public static PinSize getFallenPin(int fallenPin) {
        return PinSize.of(fallenPin);
    }
}
