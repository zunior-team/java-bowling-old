package feed;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MonitorTest {

    @Test
    public void flatMapTest(){
        List<String> list1 = Arrays.asList("NAME", "1", "2", "3", "4");
        List<String> list2 = Arrays.asList("ppp", "", "", "", "");
        List<List<String>> list = Arrays.asList(list1, list2);

        list.stream()
                .map(elements -> elements.stream()
                        .map(element -> String.format("%6s", element))
                        .collect(Collectors.toList()))
                .map(line -> "|" + String.join("|", line) + "|")
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
