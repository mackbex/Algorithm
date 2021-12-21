package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SaveQueen {

//    public static void main(String[] args) {
//
//        SaveQueen SQ = new SaveQueen();
//        Scanner kb = new Scanner(System.in);
//        int n = kb.nextInt();
//        int k = kb.nextInt();
//
//        System.out.println(SQ.solution(n,k));
//    }
//
//    protected int solution(int n, int m) {
//        Queue<Integer> q = new LinkedList<>();
//
//        for(int i = 0; i < n; i++) {
//            q.add(i+1);
//        }
//
//
//        int cnt = 0;
//        while(q.size() > 1) {
//            if(cnt == m - 1) {
//                q.poll();
//                cnt = 0;
//            }
//            else {
//                cnt++;
//                q.add(q.poll());
//            }
//        }
//
//        return q.peek();
//    }
}
