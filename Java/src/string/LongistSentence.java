package string;

import java.util.Scanner;

public class LongistSentence {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();

        String res = "";
        int m = Integer.MIN_VALUE;
        int idx = 0;

        while((idx = s.indexOf(" ")) != -1) {
            String temp = s.substring(0, idx);

            if(temp.length() > m) {
                m = temp.length();
                res = temp;
            }
            s = s.substring(idx+1);
        }
        if(s.length() > m) res = s;
        System.out.println(res);
    }

//    System.out.println(input1 + input2);
}
