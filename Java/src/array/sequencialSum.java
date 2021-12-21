package array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sequencialSum {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int[] res = new int[n];
        for(int i = 0 ;i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; j++) {
                if(ar[j]> ar[i]) cnt ++;
            }
            res[i] = cnt;
        }

        for(int i : res) {
            System.out.print(i+ " ");
        }
    }

}
