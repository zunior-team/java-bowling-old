package bowling;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

@DisplayName("학습 테스트")
public class StudyTest {

    @Test
    @DisplayName("스택을 스트림으로 사용하면?")
    void stackStream() {
        Stack<Integer> stack = new Stack<>();

        stack.add(1);
        stack.add(2);
        stack.add(3);

        stack.stream()
                .forEach(System.out::println);

        stack.clear();
        stack.add(3);
        stack.add(2);
        stack.add(1);

        stack.stream()
                .forEach(System.out::println);

        System.out.println(stack.peek());
    }
}
