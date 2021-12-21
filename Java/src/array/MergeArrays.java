package array;

import java.util.*;

public class MergeArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            q1.add(sc.nextInt());
        }
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            q2.add(sc.nextInt());
        }


        ArrayList<Integer> list = new ArrayList<>();
        while(!q1.isEmpty() && !q2.isEmpty()) {

            int f = q1.peek();
            int s = q2.peek();

            if(f < s) list.add(q1.poll());
            else list.add(q2.poll());
        }

        while(!q1.isEmpty()) list.add(q1.poll());
        while(!q2.isEmpty()) list.add(q2.poll());

        for(int nn : list) {
            System.out.println(nn + " ");
        }


    }
}
