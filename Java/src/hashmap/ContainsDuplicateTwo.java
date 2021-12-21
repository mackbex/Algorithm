package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class ContainsDuplicateTwo {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new int[]{1,2,3,1,2,3},
                2
        ));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) return ;
            }
            map.put(nums[i], i);
        }
        return ;


//        System.out.println("A");
    }
}
