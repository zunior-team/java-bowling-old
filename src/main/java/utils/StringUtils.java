package utils;

public class StringUtils {

    public static final String EMPTY = "";

    private StringUtils() {
    }

    public static boolean isEmpty(String string) {
        return (string == null || string.isEmpty());
    }

    public static boolean isEnglishLettersOnly(String string) {
        return string.chars().allMatch(Character::isAlphabetic);
    }
}
