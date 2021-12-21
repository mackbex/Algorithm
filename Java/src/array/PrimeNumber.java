package array;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] na = new Integer[n+1];
        int cnt = 0;
        if(n == 0 || n == 1) {
//            res += n;
            return;
        }
        na[0] = 1;
        na[1] = 1;

        for(int i = 2 ; i <= n ; i++) {
            if(na[i] == null) {
                cnt ++;
                for(int j = 0; j <= n; j +=i) {
                    na[j] = 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
