package string;

import java.util.Scanner;
import java.util.Stack;

public class ReverseChar {

    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        char[] n = in.nextLine().toCharArray();

        System.out.println(solution1(n));
    }



    static char[] solution1(char[] n) {

        int firstIdx = 0;
        int lastIdx = n.length - 1;

        while(firstIdx < lastIdx) {
            if(!Character.isAlphabetic(n[firstIdx])) firstIdx++;
            else if(!Character.isAlphabetic(n[lastIdx])) lastIdx--;
            else {
                char tmp = n[firstIdx];
                n[firstIdx] = n[lastIdx];
                n[lastIdx] = tmp;
                firstIdx ++;
                lastIdx --;
            }
        }
        return n;
    }
}
