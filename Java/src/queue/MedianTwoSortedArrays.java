package queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ArrayArgumentsProvider;

import java.util.*;
import java.util.stream.Stream;

public class MedianTwoSortedArrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : nums1) minHeap.add(i);
        for (int i : nums2) minHeap.add(i);
        int half = nums1.length + nums2.length;
        if (half % 2 == 0) {
            half /= 2;
            half--;
            while (half > 0) {
                minHeap.poll();
                half--;
            }
            int a = minHeap.poll();
            int b = minHeap.poll();
            return (a + b) * 1.0 / 2;
        } else {
            half /= 2;
            while (half > 0) {
                minHeap.poll();
                half--;
            }
            return minHeap.poll() * 1.0;
        }
    }


    static Stream<Arguments> inputProvider() {
        return Stream.of(
                Arguments.of(
                        (Object) new int[] {4,5,6,8,9},
                        (Object) new int[] {1,2,43,3,10}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("inputProvider")
    public void test(int[] nums1, int[] nums2) {
        findMedianSortedArrays(nums1,nums2);

    }
}
