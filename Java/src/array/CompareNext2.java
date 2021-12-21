package array;

import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;

import java.util.LinkedList;
import java.util.List;

public class CompareNext2 {
    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(
                            array = {130,135,148,140,145,150,150,153}
                    )
            }
    )
    void test(int[] vals) {

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < vals.length - 1; i++) {
            if(vals[i + 1] > vals[i]) {
                list.add(vals[i+1]);
            }
        }

        System.out.println(list.stream().toString());
    }
}
