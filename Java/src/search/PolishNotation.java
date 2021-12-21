package search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Stack;
import java.util.stream.Stream;

public class PolishNotation {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of((Object) new String[]{"4","13","5","/","+"}));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        int res = 0;
        for(String str : tokens) {
            switch (str) {
                case "+" : {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b + a);
                    break;
                }
                case "-" : {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b - a);
                    break;
                }
                case "*" : {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b * a);
                    break;
                }
                case "/" : {
                    int a = s.pop();
                    int b = s.pop();
                    s.push(b / a);
                    break;
                }
                default: s.push(Integer.parseInt(str));
            }
        }

        res = s.pop();

        Assertions.assertEquals(6, res);
    }
}
