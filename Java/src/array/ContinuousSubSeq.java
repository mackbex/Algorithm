package array;

import java.util.*;

public class ContinuousSubSeq {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }


        int lt = 0;
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            sum += ar[i];
            if(sum == m) cnt++;
            while(sum >= m) {
                sum -= ar[lt++];
                if(sum == m) cnt++;
            }
        }
//
//        while(rt < n) {
//            if(sum == m) {
//                cnt ++;
//                sum = ar[++rt];
//                lt = rt;
//            }
//            else if(sum < m) {
//                if(++lt >= ar.length) break;
//                sum += ar[lt];
//            }
//            else {
//                sum = ar[++rt];
//                lt = rt;
//            }
//
//        }

        System.out.println(cnt);
    }
}
