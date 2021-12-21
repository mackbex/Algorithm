package stack;

import java.util.Scanner;
import java.util.Stack;

public class Pipe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> s = new Stack<>();

        int cnt = 0;
        for(int i = 0; i < str.length(); i++) {

            if(str.charAt(i) == '(') s.push(str.charAt(i));
            else  {
                s.pop();
                if(str.charAt(i-1) == '(' ) cnt += s.size();
                else cnt ++;
            }
        }


        System.out.println(cnt);
    }
}
