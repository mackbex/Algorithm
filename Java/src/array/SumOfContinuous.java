package array;

import java.util.Scanner;

public class SumOfContinuous {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int res = 0;
        int sum = 0;
        int lt = 0;
        int m = n / 2 + 1;
        int[] ar = new int[m];
        for(int i = 0; i < m; i++) ar[i] = i+1;

        for(int rt = 0; rt < m; rt++) {
            sum += ar[rt];
            if(sum == n) res ++;
            while(sum >= n) {
                sum -= ar[lt++];
                if(sum == n) res ++;
            }
        }


        System.out.print(res);
    }
}
