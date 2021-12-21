package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BindMento {


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        int[][] ar = new int[x][n];
        for(int i = 0; i < x; i++) {

            for(int j = 0; j < n; j++) {
                ar[i][j] = sc.nextInt();
            }
        }


        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < ar[0].length; i++) {
            map.put(i+1, 0);
        }

        for(int st = 1; st <= ar[0].length; st ++) {
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar[0].length; j++) {
                    if(st == ar[i][j]) {
                        map.put(st, Math.max(map.get(st),j));
                        break;
                    }
                }
            }
        }

        int cnt = 0;
        for(int val : map.keySet()) {
            cnt = cnt + ar[0].length - (map.get(val) + 1);
        }

        System.out.println("A");

    }


}
