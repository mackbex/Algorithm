package hashset;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class JewelAndStones {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of(
                (Object) "aA",
                (Object) "aAAbbbb"
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(String j, String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        for(char c : j.toCharArray()) set.add(c);

        for(char c : s.toCharArray()) {
            if(set.contains(c)) res++;
        }
    }
}
