import org.junit.jupiter.params.ParameterizedTest;

import java.util.*;

public class test {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        swap(a, b);
        // a, b 값은?

        test(a, b);
        // a, b 값은?
    }

    static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    static void test(int a, int b) {
        a = 100;
        b = 200;
    }

//    public static void main(String[] args) {
//
//
//        int[] ca = new int[26];
//        String s = "aabbffddeaee";
//        for(char c : s.toCharArray()) {
//            ca[c - 'a'] ++;
//        }
//        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
//
//        for(int i : ca) {
//            if(i != 0) q.add(i);
//        }
//
//        int cnt = 0;
//        while(!q.isEmpty()) {
//            int most = q.poll();
//
//            if(q.isEmpty()) return;
//            if(most == q.peek()) {
//                if (most > 1) {
//                    q.add(most - 1);
//                }
//                cnt++;
//            }
//        }
//
//
//
//
//        System.out.println(cnt);
//    }
//
//    void test() {
////        Map<Character, Integer> map = new HashMap<>();
////
////        map.put('B',0);
////        map.put('A',0);
////        map.put('L',0);
////        map.put('O',0);
////        map.put('N',0);
////
////        String S = "BAOOLLNNOOLGBAX";
////        for(int i = 0; i < S.length(); i++) {
////            char c = S.charAt(i);
////            if(map.get(c) != null) {
////                map.put(c, map.get(c) + 1);
////            }
////
////        }
////
////        map.put('L', map.get('L') / 2);
////        map.put('O', map.get('O') / 2);
////
////        int res = map.get('B');
////        for(int n : map.keySet()) {
////
////            char c = (char) n;
////            if(map.get(c) <= 0) {
////                res = 0;
////                break;
////            }
////            res = Math.min(res, map.get(c));
////        }
////
////        System.out.println(res);
//    }

}
