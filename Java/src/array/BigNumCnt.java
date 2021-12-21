package array;

import java.util.Scanner;

public class BigNumCnt {

    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};
    static int cnt = 0;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] ar = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
            }
        }

        BigNumCnt m = new BigNumCnt();
        for(int i = 0; i < ar.length; i++) {
            for(int j = 0; j < ar[0].length; j++) {
                if(ar[i][j] != '0') {
                    m.comp(ar, i ,j);
                }
            }
        }

        System.out.println(cnt);

    }

    void comp(int ar[][], int x, int y) {

        boolean isbig = true;
        for(int i = 0; i < 4; i ++) {
            int nX = x + dx[i];
            int nY = y + dy[i];

            if(
                    nX >= 0
                    && nY >= 0
                    && nX < ar.length
                    && nY < ar[0].length
                    && ar[nX][nY] != '0'
            ) {

                if(ar[x][y] < ar[nX][nY])  {
                    isbig = false;
                    break;
                }
            }

        }

        if(isbig) {
            cnt++;
        }

//        return ar[x][y];
    }

}
