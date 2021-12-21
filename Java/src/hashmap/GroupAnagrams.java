package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class GroupAnagrams {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) new String[]{"eat","tea","tan","ate","nat","bat"},
                2
        ));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            List<String> list = map.getOrDefault(c, new LinkedList<>());
            list.add(s);
            map.put(key,list);
        }


        List<List<String>> res = new LinkedList<>();
        for(String idx : map.keySet()) {
            res.add(map.get(idx));
        }


        System.out.println("A");
    }
}
