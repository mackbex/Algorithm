package string;

import java.util.Scanner;

public class Password {


    public static void main(String[] args){

        Scanner in= new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());
        String s = in.nextLine();

        String res = "";
        for(int i = 0; i < size*7; i +=7) {
            char ch  = (char) Integer.parseInt(s.substring(i, i+7)
                    .replaceAll("#","1")
                    .replaceAll("\\*","0"),2);

            res += ch;

        }


        System.out.println(res);
    }
}
