package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

public class DailyTemperature {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(new int[]{1,4,3,2,5,1,6,6}));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {
            while(!s.empty() && temperatures[s.peek()] < temperatures[i]) {
                int idx = s.pop();
                result[idx] = i - idx;
            }

            s.push(i);
        }

    }
}
