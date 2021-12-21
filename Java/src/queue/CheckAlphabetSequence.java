package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckAlphabetSequence {

    public static void main(String[] args) {

        CheckAlphabetSequence SQ = new CheckAlphabetSequence();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();

        System.out.println(SQ.solution(a, b));
    }

    protected String solution(String a, String b) {

        Queue<Character> q = new LinkedList<>();
        for(char ch : a.toCharArray()) {
            q.add(ch);
        }

        for(char ch : b.toCharArray()) {
            if(q.size() > 0  && ch == q.peek()) {
                q.poll();
            }
        }

        if(q.size() > 0) {
            return "NO";
        }
        else {
            return "YES";
        }
    }
}
