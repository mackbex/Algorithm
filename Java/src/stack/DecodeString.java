package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Stack;

public class DecodeString {

    @ParameterizedTest
    @ValueSource(strings = "3[a2[c]]")
    void test(String s) {
        String res = decode(s);
        Assertions.assertEquals("accaccacc", res);
    }
    String decode(String s) {

        Stack<Integer> num = new Stack<>();
        Stack<StringBuilder> str = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int i = 0;
        for(char ch : s.toCharArray()) {
            if(ch >= '0' && ch <= '9') {
                i = i * 10 + Character.getNumericValue(ch);
            }
            else if(ch == '[') {
                num.push(i);
                str.push(sb);
                sb = new StringBuilder();
                i = 0;
            }
            else if(ch == ']') {
                StringBuilder decodeStr = str.pop();
                for(int times = num.pop() ; times > 0; times --) {
                    decodeStr.append(sb);
                }
                sb = decodeStr;
            }
            else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
