package com.zuniorteam.bowling.core.user;

import com.zuniorteam.bowling.util.StringUtil;

public class User {

    private final String username;

    public User(String username) {
        validate(username);
        this.username = username;
    }

    private void validate(String username) {
        if(StringUtil.isEmpty(username)){
            throw new IllegalArgumentException("이름이 없습니다");
        }
    }

    public String getUsername() {
        return username;
    }
}
