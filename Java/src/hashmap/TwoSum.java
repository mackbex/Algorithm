package hashmap;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSum {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new int[]{2,7,11,15},
                9
        ));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target-numbers[i])) {
                res[0] = map.get(target-numbers[i]);
                res[1] = i;
                return;
            }
            map.put(numbers[i], i);
        }

        System.out.println("A");
    }
}
