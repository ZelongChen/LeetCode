package leetcode.solutions.Top100LikedQuestions.Easy;

import java.util.Stack;

public class ValidParentheses_20 {
  //这种判断对称的问题，很常见的是要利用堆栈先进后出的特性
  //思路
  //1. string的长度必须是偶数，奇数的话肯定是false
  //2. 遍历字符串，
  //3. 如果是左括号，就放进堆栈
  //4. 如果是右括号，如果堆栈为空，则false,
  //5. 如果是右括号，且堆栈不为空，则弹出堆栈上的字符，判断和当前字符是否对应，如果不对应则false
  //6. 最后判断堆栈是否已经清空
  public static boolean solutionWithStack(String s) {
    if (s.length() % 2 == 1) {
      return false;
    }
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(' || c == '{' || c == '[') {
        stack.push(c);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char p = stack.pop();
        if (p == '(' && c != ')') {
          return false;
        }
        if (p == '[' && c != ']') {
          return false;
        }
        if (p == '{' && c != '}') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}