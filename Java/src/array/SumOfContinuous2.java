package array;

import java.util.Scanner;

public class SumOfContinuous2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int length = 0;
        int cnt = 0;
        int lt = 0;

        for(int i = 0; i < a.length; i++) {
            if(a[i] == 0) cnt++;
            while(cnt > m) {
                if(a[lt] == 0) cnt --;
                lt ++;
            }

            length = Math.max(length, i - lt + 1);
        }


        System.out.print(length);
    }
}
