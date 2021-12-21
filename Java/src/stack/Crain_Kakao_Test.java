package stack;

import java.util.Scanner;
import java.util.Stack;

public class Crain_Kakao_Test {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] ar = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] move = new int[m];
        for(int i = 0; i < m; i++) {
            move[i] = sc.nextInt();
        }

        int cnt = 0;
        Stack<Integer> s = new Stack<>();

        for(int next : move) {

            for(int i = 0; i < n; i++) {
                int cur = ar[i][next-1];
                if(cur != 0) {
                    if(!s.isEmpty() && s.peek() == cur) {
                        s.pop();
                        cnt +=2;
                    }
                    else {
                        s.push(cur);
                    }

                    ar[i][next-1] = 0;
                    break;
                }
            }

        }

    }
}
