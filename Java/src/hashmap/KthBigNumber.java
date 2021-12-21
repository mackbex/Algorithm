package hashmap;

import java.util.*;

public class KthBigNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int[] c = new int[a];
        for(int i = 0; i < a; i++) {
            c[i] = sc.nextInt();
        }

        Set<Integer> s = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < a; i++) {
            for(int j = i+1; j < a; j++) {
                for(int k = j + 1; k < a; k++) {
                    s.add(c[i]+c[j]+c[k]);
                }
            }
        }

        int res = -1;
        int cnt = 0;
        for(int n : s) {
            cnt ++;
            if(cnt == b) res = n;
        }

        System.out.println(res);

//        System.out.println(cnt);

    }
}
