package com.zuniorteam.bowling;

import com.zuniorteam.bowling.core.user.User;

public class InputRender {
    public static User getUser(String username) {
        return new User(username);
    }
}
