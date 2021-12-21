package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TargetSum {

    static Stream<Arguments> paramProvider() {
        return Stream.of(
                Arguments.of((Object) new int[]{
                        1,1,1,1,1
                }, 3));
    }

    int count = 0;
    @ParameterizedTest
    @MethodSource("paramProvider")
    void test(int[] nums, int S) {

        calculate(nums,0, 0, S);

        Assertions.assertEquals(5,count);
    }

    //recursion
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public int DynamicOne(int[] nums, int S) {
        int sum = 0;
        for (int num: nums) sum += num;
        if (S > sum || -S < -sum) return 0;

        int[] dp = new int[2 * sum + 1];
        dp[sum] = 1;

        for (int num: nums) {
            int[] next = new int[2 * sum + 1];
            for (int i = 0; i < dp.length; i++) {
                // Only branch out from reachable target sums
                if (dp[i] == 0) continue;
                next[i + num] += dp[i];
                next[i - num] += dp[i];
            }
            dp = next;
        }

        return dp[sum + S];
    }
}
