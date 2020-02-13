//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。 
//
// 示例 1: 
//
// 输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
// 
//
// 示例 2: 
//
// 输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
// 
// Related Topics 字符串 动态规划

  
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses{
  public static void main(String[] args) {
       Solution solution = new LongestValidParentheses().new Solution();
      System.out.println(solution.longestValidParentheses(")()())"));
  }
  
//还可以用动态规划尝试
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);//哨兵，处理边界问题
        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if(c.equals("(")){
                stack.push(i);
            }else{
                Integer pop = stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    Integer peek = stack.peek();
                    max = Math.max(max,i-peek);
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}