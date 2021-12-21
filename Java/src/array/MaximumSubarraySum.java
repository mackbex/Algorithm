package array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class MaximumSubarraySum {

    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(

                      (Object) new int[] {-2,1,-3,4,-1,2,1,-5,4}

//                        (Object) new int[] {2,-5,1,-4,3,-2}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void test(int[] A) {
        int localMax = A[0];
        int globalMax = A[0];
        for(int i = 1; i < A.length; i++) {
            localMax = Math.max(A[i], localMax + A[i]);
            if(localMax > globalMax) {
                globalMax = localMax;
            }
        }

//        int max = nums[0];
//        for(int i = 1; i < nums.length; i++) {
//            int sum = 0;
//            for(int j = i; j >= 0 ; j --) {
//                sum += nums[j];
//                max = Math.max(max, sum);
//            }
//        }
//
        System.out.println(globalMax);
    }
}


