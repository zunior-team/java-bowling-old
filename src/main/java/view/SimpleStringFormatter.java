package view;

import spark.utils.CollectionUtils;
import utils.StringUtils;

import java.util.List;
import java.util.Objects;

public class SimpleStringFormatter implements StringFormatter {

    private final String format;

    private SimpleStringFormatter(String format) {
        if (StringUtils.isEmpty(format)) {
            throw new IllegalArgumentException("format cannot be null or empty");
        }
        this.format = format;
    }

    public static SimpleStringFormatter newInstanceWithFormat(String format) {
        return new SimpleStringFormatter(format);
    }

    @Override
    public String format(List<String> args) {
        if (CollectionUtils.isEmpty(args)) {
            throw new IllegalArgumentException("args cannot be empty");
        }

        return String.format(format, args.stream()
                .filter(Objects::nonNull)
                .toArray());
    }

}
