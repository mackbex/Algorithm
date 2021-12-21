package array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.ArrayArgumentsProvider;

import java.util.LinkedList;
import java.util.List;

public class CompareNext {

    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(
                            array = {7,3,9,5,6,12}
                    )
            }
    )
    void test(int[] vals) {

        List<Integer> list = new LinkedList<>();
        list.add(vals[0]);
        for(int i = 0; i < vals.length - 1; i++) {
            if(vals[i + 1] > vals[i]) {
                list.add(vals[i+1]);
            }
        }

        System.out.println(list.stream().toString());
    }
}
