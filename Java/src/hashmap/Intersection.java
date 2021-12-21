package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Intersection {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new int[]{4,9,5},
                (Object) new int[]{9,4,9,8,4}
        ));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums1) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        List<Integer> res = new ArrayList<>();

        for(int n : nums2) {
            if(map.containsKey(n) && map.get(n) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }



        System.out.println("A");
    }
}
