package com.zuniorteam.bowling.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionUtil {

    private CollectionUtil(){}

    public static <T,R> List<R> simpleMap(List<T> collection, Function<T, R> mapper){
        return collection.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }
}
