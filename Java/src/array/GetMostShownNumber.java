package array;

import java.util.Scanner;

public class GetMostShownNumber {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] ar = new int[n][n];
        for(int i = 0; i < n; i++) {

            for(int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
            }
        }

        int res = 0;
        for(int i = 0; i < ar.length; i++) {
            int cnt = 0;
            for(int j = 0; j < ar.length; j++) {
                if(i == j) continue;
                for(int k = 0; k < 5; k ++) {
                    if(ar[i][k] == ar[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            res = Math.max(res, cnt);
        }

        System.out.println(res + 1);

    }


}
