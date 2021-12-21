package string;

import java.util.Scanner;

public class DisplayNumber {

    public static void main(String[] args){

        Scanner in= new Scanner(System.in);
        long s = Long.parseLong(in.nextLine().replaceAll("[^0-9]",""));



        System.out.println(s);
    }
}
