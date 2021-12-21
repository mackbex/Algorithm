package string;

import java.util.Scanner;
import java.util.Stack;

public class OppositeElement {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        char[] n = in.nextLine().toCharArray();
        int lastIdx = n.length - 1;
        for(int i = 0; i < n.length / 2 ; i++, lastIdx --) {
            char temp = n[i];
            n[i] = n[lastIdx];
            n[lastIdx] = temp;
        }

        System.out.println(n);
    }


    static String solution2(char[] n) {

        int lastIdx = n.length - 1;
        for(int i = 0; i < n.length / 2 ; i++, lastIdx --) {

            char temp = n[i];
            n[i] = n[lastIdx];
            n[lastIdx] = temp;

        }

        System.out.println(n);
        return n.toString();
    }

    static String solution1(char[] n) {
        Stack<Character> s = new Stack<>();


        for(char c : n) {
            s.push(c);
        }

        String res = "";

        while(!s.isEmpty()) {
            res += s.pop();
        }

        return res;
    }
}
