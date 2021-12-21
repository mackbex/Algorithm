package hashset;

import org.junit.jupiter.params.ParameterizedTest;
import utils.ArrayArgumentsProvider;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    @ParameterizedTest
    @ArrayArgumentsProvider.ArraySources(
            arrays = {
                    @ArrayArgumentsProvider.ArraySource(
                            array = {1,2,2,1}
                    ),
                    @ArrayArgumentsProvider.ArraySource(
                            array = {2,2}
                    )
            }
    )
    void test(int[] nums1, int[] nums2) {
        Set<Integer> s = new HashSet<>();


        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;

        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] == nums2[j]) {
                s.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) {
                j++;
            }
            else {
                i++;
            }
        }

        int[] res = new int[s.size()];
        int x = 0;
        for(Integer n : s) {
            res[x++] = n;
        }

        return;
    }
}
