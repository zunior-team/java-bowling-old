package com.zuniorteam.bowling.util;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class StringUtil {

    private StringUtil() {}

    public static boolean isEmpty(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    public static String fillToCentered(String base, Character token, int length) {

        final int lengthOfFill = length - base.length();

        final String filled = IntStream.range(0, lengthOfFill / 2)
                .mapToObj(i -> token.toString())
                .collect(Collectors.joining());

        if(lengthOfFill % 2 == 1){
            return filled +  base + filled  + token;
        }

        return filled + base + filled;
    }

}
