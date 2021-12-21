package array;

import java.util.*;
import java.util.stream.Collectors;

public class Fibo {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n == 0) return;
        if(n == 1) return;
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2 ; i < n ; i++) {
            int nextVal = res[i - 1] + res[i - 2];
            res[i] = nextVal;
        }

        for(int nn : res) {
            System.out.print(nn+ " ");
        }
    }
}
