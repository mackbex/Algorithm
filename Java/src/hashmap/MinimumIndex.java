package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MinimumIndex {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new String[]{"Shogun","Tapioca Express","Burger King","KFC"},
                (Object) new String[]{"KNN","Shogun","Burger King","Tapioca Express","KFC"}
        ));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.put(list1[i],i);
        }

        List<String> res = new ArrayList<>();
        int min = Integer.MAX_VALUE, sum;
        for(int i = 0; i < list2.length && i <= min; i++) {
            if(map.containsKey(list2[i])) {
                sum = i + map.get(list2[i]);
                if(sum < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = sum;
                }
                else if(sum == min) {
                    res.add(list2[i]);
                }
            }
        }




        System.out.println("A");
    }
}
