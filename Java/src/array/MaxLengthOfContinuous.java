package array;

import java.util.Scanner;

public class MaxLengthOfContinuous {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int res = 0;
        int cnt = 1;
        n--;
        while(n>0) {
            cnt ++;
            n -= cnt;
            if(n%cnt == 0) res ++;

        }


        System.out.print(res);
    }
}
