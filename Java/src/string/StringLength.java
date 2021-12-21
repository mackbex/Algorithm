package string;

import java.util.Scanner;

public class StringLength {


    public static void main(String[] args){

        Scanner in= new Scanner(System.in);
        char[] c = in.nextLine().toLowerCase().toCharArray();
        char comp = in.nextLine().charAt(0);

        int pos = 0;
        int[] res = new int[c.length];

        for(int i = 0; i < c.length; i++) {
            if(comp == c[i]) {
                pos = 0;
            }
            else {
                pos++;
            }
            res[i] = pos;
        }

        pos = Integer.MAX_VALUE;
        for(int i = c.length-1; i >= 0; i--) {
            if(comp == c[i]) {
                pos = 0;
            }
            else {
                pos++;
                res[i] = Math.min(res[i],pos);
            }
        }



        for(int i : res) {
            System.out.print(i + " ");

        }
    }
}
