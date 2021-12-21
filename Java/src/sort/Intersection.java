package sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

public class Intersection {


    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of((Object) new int[]{1,2,4,6,5},
                        (Object) new int[]{3,4}
        ));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    void intersection(int[] ar, int[] comp) {

        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;

        Arrays.sort(ar);
        Arrays.sort(comp);

        while(i < ar.length && j < comp.length) {
            if(ar[i] == comp[j]) {
                list.add(ar[i]);
                i ++;
                j ++;
            }
            else if(ar[i] < comp[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        System.out.println(list.toArray());
    }
}
