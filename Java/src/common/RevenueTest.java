import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RevenueTest {

    @Test
    public void run() {
        int[] a = {1,2,3,4};
        String[] c = {"b","c"};
        Assert.assertEquals(RevenueTest.solution(a), "a");
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int cur = 0;
        int move = 0;

        // 시간복잡도 : O(n)
        // 1. A 배열 전체 루프
        for(int i = 0; i < A.length; i++) {
            // 2. 현재 값이 0일 경우
            // 2-1. A[i]의 값이 0보다 클 경우 : cur은 A[i]의 값을 가지게 한다.
            // 2-2. 반대의 경우 : 옮기는 횟수에 + 1을 한다.
            if(cur == 0) {
                if(A[i] > 0) {
                    cur = A[i];
                }
                else {
                    move += 1;
                }
            }
            // 3. 현재값이 0이 아닐 경우
            // 3-1. A[i] 값이 0보다 클 경우 : cur값에 A[i]값을 더한다.
            // 3-2. 반대의 경우 : 현재값과 A[i]의 값을 뺸 값이 0보다 작으면 옮기는 횟수에 + 1을 한다.
            else {
                if(A[i] > 0) {
                    cur += A[i];
                }
                else if(cur + A[i] <= 0) {
                    move += 1;
                }
            }
        }

        return move;
    }
}