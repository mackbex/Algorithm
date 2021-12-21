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

public class FirstUniqueCharacter {

    @ParameterizedTest
    @ValueSource(
            strings = {"loveleetcode"}
    )
    void test(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return;
            }
        }

        System.out.println("A");
    }
}
