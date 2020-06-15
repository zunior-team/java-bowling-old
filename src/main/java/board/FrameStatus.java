package board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrameStatus {

    private static final String NAME_STRING = "NAME";
    private static final List<String> FRAME_STATUS = new ArrayList<>();

    static {
        FRAME_STATUS.add(NAME_STRING);
        FRAME_STATUS.addAll(IntStream.rangeClosed(1, 10)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList()));
    }

    public List<String> getFrameStatus(){
        return Collections.unmodifiableList(FRAME_STATUS);
    }
}
