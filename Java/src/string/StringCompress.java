package string;

import java.util.Scanner;

public class StringCompress {


    public static void main(String[] args){

        Scanner in= new Scanner(System.in);
        String s = in.nextLine();

        s += " ";
        char[] c = s.toCharArray();
        char target = c[0];
        int idx = 1;
        int cnt = 1;
        String res = "";

        while(idx < c.length) {

            if(target == c[idx]) {
                cnt ++;
            }
            else {
                res += target+"";
                if(cnt >1) res +=cnt;
                target = c[idx];
                cnt = 1;
            }
            idx ++;
        }


        System.out.println(res);
    }
}
