package view;

import utils.StringUtils;

public class FrameStringFormatterFactory {

    public StringFormatter create(int sizeOfHistories) {
        if (sizeOfHistories == 1) {
            return SimpleStringFormatter.newInstanceWithFormat(" %s ");
        }
        if (sizeOfHistories == 2) {
            return SimpleStringFormatter.newInstanceWithFormat("%s|%s");
        }
        if (sizeOfHistories == 3) {
            return SimpleStringFormatter.newInstanceWithFormat("%s|%s|%s");
        }
        return args -> StringUtils.EMPTY;
    }
}
