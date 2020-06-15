package monitor;

import java.util.List;

public class OutputView {

    public static void printStatus(final List<String> lines){
        lines.forEach(System.out::println);
        System.out.println();
    }
}
