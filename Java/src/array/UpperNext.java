package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UpperNext {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 0;  i < m; i++) sum += ar[i];
        int res = sum;
        for(int i = m; i < n; i++) {
            sum += (ar[i] - ar[i-m]);
            res = Math.max(res, sum);
        }

        System.out.print(res);
    }
}
