package array;

import java.util.*;

public class Intersection {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ar1 = new int[n];
        for(int i = 0; i < n; i++) {
            ar1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] ar2 = new int[m];
        for(int i = 0; i < m; i++) {
            ar2[i] = sc.nextInt();
        }

        Arrays.sort(ar1);
        Arrays.sort(ar2);

        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while(i < ar1.length && j < ar2.length) {

            if(ar1[i] == ar2[j]) {
                res.add(ar1[i]);
                i++;
                j++;
            }
            else if(ar1[i] < ar2[j]) {
                i++;
            }
            else {
                j++;
            }
        }


        for(int nn : res) {
            System.out.print(nn + " ");
        }
    }
}
