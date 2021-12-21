package stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Integer> s = new Stack<>();


        for(char c: str.toCharArray()) {
            if(Character.isDigit(c)) {
                s.push(c-'0');
            }
            else {
                int rt = s.pop();
                int lt = s.pop();

                int calc = 0;
                switch (c) {
                    case '+' :
                        calc = lt + rt;
                        break;
                    case '-' :
                        calc = lt - rt;
                        break;
                    case '*' :
                        calc = lt * rt;
                        break;

                    case '/' :
                        calc = lt / rt;
                        break;
                }

                s.push(calc);
            }
        }

        System.out.println(s.get(0));
    }
}
