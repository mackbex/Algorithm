package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class IsomorphicStrings {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) "egg",
                (Object) "adz"
        ));
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    void test(String s, String t) {


        int[] spos = new int[256];
        int[] tpos = new int[256];
        for(int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            if(spos[sc] != tpos[tc])
                return;
            spos[sc] = i + 1;
            tpos[tc] = i + 1;
        }


        System.out.println("A");
    }

    String transform(String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c,i);
            }

            sb.append(Integer.toString(map.get(c)));
            sb.append(" ");
        }
        return sb.toString();
    }
}
