package com.zuniorteam.bowling.view.render;

import com.zuniorteam.bowling.core.value.PitchResultType;
import com.zuniorteam.bowling.core.value.PinSize;

import java.util.HashMap;
import java.util.Map;

public class PitchResultRender {

    private static final Map<PitchResultType, String> TOKEN = new HashMap<>();

    private static final String TOKEN_GUTTER = "-";
    private static final String TOKEN_STRIKE = "X";
    private static final String TOKEN_SPARE = "/";

    static {
        TOKEN.put(PitchResultType.GUTTER, TOKEN_GUTTER);
        TOKEN.put(PitchResultType.STRIKE, TOKEN_STRIKE);
        TOKEN.put(PitchResultType.SPARE, TOKEN_SPARE);
    }

    public static String rend(PitchResultType pitchResultType, PinSize fallenPinSize) {
        if (TOKEN.containsKey(pitchResultType)) {
            return TOKEN.get(pitchResultType);
        }

        return String.valueOf(fallenPinSize);
    }

}
