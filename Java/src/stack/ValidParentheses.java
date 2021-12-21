package stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {


    @ParameterizedTest
    @ValueSource(strings = "(]")
    void test(String s) {


        Assertions.assertTrue(comp(s));
    }

    boolean comp(String s) {
        boolean isValid = false;
        Map<Character, Character> mappings =new HashMap<>();
        mappings.put('}','{');
        mappings.put(')','(');
        mappings.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(stack.isEmpty() || stack.pop() != mappings.get(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
