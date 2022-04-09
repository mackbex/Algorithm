import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    @Test
    public void run() {
        int[] t = {10,1,3,1,2,2,1,0,4};

        Assert.assertEquals(Solution.solution(1124), false);
    }
    List<Set<Integer>> list = new LinkedList<>();
    public static boolean solution(int n) {
        if(n == 0 || n == 1) return false;

        int limit = (int)Math.sqrt(n);

        for(int i = 2; i <= limit; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    private static int getCount(int idx, int sum, int[] arr) {
        int n = arr.length;
        if (idx >= n-1) {
            return 0;
        }

        int count = 0;
        if (arr[idx] + arr[idx+1] == sum)
            count = 1 + getCount(idx+2, sum, arr);


        return Math.max(count, getCount(idx+1, sum, arr));
    }

//    public static int solution(int[] arr) {
//        int max=0;
//        for(int i=0;i<arr.length-1;i++){ //for every adj pair check how many other pairs are there with same sum/
//            int reqSum=arr[i]+arr[i+1];
//            int reqSumCount=1;
//            for(int j=0;j<arr.length-1;){
//                if((j<i && (j+1)<i)||(j>(i+1))) {
//                    if ((arr[j] + arr[j + 1]) == reqSum) {
//                        reqSumCount++;
//                        j+=2;
//                    }else{
//                        j++;
//                    }
//                }else
//                    j++;
//            }
//            if(max<reqSumCount)
//                max=reqSumCount;
////System.out.println(reqSum + " has total count = " + reqSumCount);
//        }
//        return max;
//    }
}