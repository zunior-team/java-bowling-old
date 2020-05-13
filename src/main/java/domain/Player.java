package domain;


import utils.StringUtils;

public class Player {
    private static final int NAME_LENGTH = 3;
    private final String name;

    private Player(String name) {
        validateName(name);
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    private void validateName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("이름은 NULL 혹은 EMPTY 일 수 없습니다.");
        }

        if (name.length() != NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 " + NAME_LENGTH + "이어야 합니다");
        }

        if (!StringUtils.isEnglishLettersOnly(name)) {
            throw new IllegalArgumentException("이름은 오직 영문자로만 구성할 수 있습니다.");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
