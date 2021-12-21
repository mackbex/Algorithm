package hashset;

import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {

    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(
                            array = {1,2,3,4}
                    )
            }
    )
    public void test(int[] ar) {
        Set<Integer> s = new HashSet<>();

        for(int i : ar) {
            if(!s.add(i)) return;
        }
    }
}
