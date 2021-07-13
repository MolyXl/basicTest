package arithmetic.structure;

import org.springframework.util.StringUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author MaZhuli
 * @version 1.0.0
 * @package arithmetic.structure description
 * @since 2021/6/28
 */
public class StackTest {
    public static void main(String[] args) {
        String s = "))(())";
        //System.out.println(isValid(s));
        //System.out.println(mySqrt(8));

        int i = longestValidParentheses(s);
        System.out.println(i);

    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }

    public static boolean isValid(String s) {
        if (StringUtils.isEmpty(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else {
                Character pop = stack.peek();
                if ((pop == '(' && aChar == ')') || (pop == '[' && aChar == ']') || (pop == '{' && aChar == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
