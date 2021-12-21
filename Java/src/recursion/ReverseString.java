package recursion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ArrayArgumentsProvider;

import java.util.stream.Stream;

public class ReverseString {

    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of((Object) new char[] {'h','e','l','l','o'}));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    public void test(char[] c) {
        String res = helper(String.valueOf(c));

        System.out.print(res);
    }

    String helper(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        return helper(s.substring(1)) + s.charAt(0) ;

    }
}
