package com.zuniorteam.bowling.view.render;

import com.zuniorteam.bowling.core.dto.StepResultDto;
import com.zuniorteam.bowling.core.value.StepResultType;

import java.util.HashMap;
import java.util.Map;

public class StepResultRender {

    private static final Map<StepResultType, String> TOKEN = new HashMap<>();

    private static final String TOKEN_GUTTER = "-";
    private static final String TOKEN_STRIKE = "X";
    private static final String TOKEN_SPARE = "/";

    static {
        TOKEN.put(StepResultType.GUTTER, TOKEN_GUTTER);
        TOKEN.put(StepResultType.STRIKE, TOKEN_STRIKE);
        TOKEN.put(StepResultType.SPARE, TOKEN_SPARE);
    }

    public static String rend(StepResultDto stepResultDto) {
        final StepResultType resultType = stepResultDto.getStepResultType();

        if (TOKEN.containsKey(resultType)) {
            return TOKEN.get(resultType);
        }

        return String.valueOf(stepResultDto.getFallenPinSize());
    }

}
