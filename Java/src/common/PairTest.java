import org.junit.Assert;
import org.junit.Test;

public class PairTest {

    @Test
    public void run() {
        int[] a = {1,2,3};
        String[] c = {"b","c"};
        Assert.assertEquals(PairTest.solution(a), 1);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int max = 0;
        //시간복잡도 : O(n^2)
        // 1. 반복문을 통해 같은 덧셈 값이 있는 쌍이 얼마나 있는지 조회.
        for(int i = 0; i < A.length-1; i++) {
            int sum = A[i] + A[i+1];
            // 2. 기본값 : 1. 같은 쌍이 없는 경우 1 리턴.
            int cnt = 1;

            // 3. A[i] + A[i + 1] 의 값과 같은 쌍이 있는지 조회.
            for(int j = 0; j < A.length -1;) {
                //sum에 포함된 쌍을 조회하는 경우를 방지하기 위해,
                //조회할 인덱스 쌍이 현재 i 인덱스의 -2 이거나,
                // i+1보다 j 인덱스가 클때만 분기를 함.
                if((j < i && (j+1) < i) || (j>(i+1))) {
                    //현재의 쌍이 sum과 일치할 경우 카운트 + 1하고 다음 쌍으로 j 인덱스를 증가시킴(+2)
                    if((A[j] + A[j+1]) == sum) {
                        cnt++;
                        j += 2;
                    }
                    else {
                        j++;
                    }
                }
                else {
                    j++;
                }
            }
            // 4. 현재의 같은 쌍 카운트가 기존 카운트보다 클 경우, 값 교체.
            if(max < cnt) {
                max = cnt;
            }
        }

        return max;
    }


//    public static int solution(int[] A) {
//        // write your code in Java SE 8
//        int n = A.length;
//
//        int ans = 0;
//        for (int i = 0; i < n-1; i++) {
//            int sum = A[i] + A[i+1];
//            ans = Math.max(ans, 1 + getCount(i+2, sum, A));
//        }
//
//        return ans;
//    }
//
//    private static int getCount(int idx, int sum, int[] arr) {
//        int n = arr.length;
//        if (idx >= n-1) {
//            return 0;
//        }
//
//        int count = 0;
//        if (arr[idx] + arr[idx+1] == sum)
//            count = 1 + getCount(idx+2, sum, arr);
//
//
//        return Math.max(count, getCount(idx+1, sum, arr));
//    }
}