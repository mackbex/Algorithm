package array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaximumAbsoluteSum {

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(

                      (Object) new int[] {3, 2, -6, 4, 0}

//                        (Object) new int[] {2,-5,1,-4,3,-2}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void test(int[] nums) {
        int s = 0, min = 0, max = 0;
        for (int a: nums) {
            s += a;
            min = Math.min(min, s);
            max = Math.max(max, s);
        }
        System.out.println(max-min);
    }
}


