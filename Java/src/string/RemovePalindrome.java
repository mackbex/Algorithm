package string;

import java.util.Scanner;

public class RemovePalindrome {

    public static void main(String[] args){

        Scanner in= new Scanner(System.in);
        char[] c = in.nextLine().toUpperCase().replaceAll("[^A-Z]","").toCharArray();

        String res = "YES";
        for(int i = 0; i < c.length / 2; i++) {
            if(c[i] != c[c.length - 1 - i]) {
                res = "NO";
                break;
            }

        }

        System.out.println(res);
    }
}
