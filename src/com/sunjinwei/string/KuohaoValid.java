package com.sunjinwei.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 验证括号是否合法
 * ps: 使用栈来判断，如果是左括号 那么入栈，如果是右括号，判断栈顶是不是需要的左括号
 */
public class KuohaoValid {

    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        List<Character> left = new ArrayList<>();
        left.add('(');
        left.add('{');
        left.add('[');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (left.contains(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == change(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private Character change(Character c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else if (c == ']') {
            return '[';
        } else {
            return c;
        }
    }
}
