package sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class InsertionSort {


    static Stream<Arguments> valueProvider() {
        return Stream.of(Arguments.of((Object) new int[]{1,2,4,6,5}));
    }
    @ParameterizedTest
    @MethodSource("valueProvider")
    void insertion(int[] ar) {

        for(int i = 1; i < ar.length; i++) {
            int idx = i;
            int temp = ar[i];

            while(idx > 0 && ar[idx - 1] > temp) {
                ar[idx] = ar[idx-1];
                idx = idx -1;
                ar[idx] = temp;
            }
        }

        System.out.println(ar);
    }
}
