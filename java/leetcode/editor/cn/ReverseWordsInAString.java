//给定一个字符串，逐个翻转字符串中的每个单词。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串

  
package leetcode.editor.cn;

import java.util.Stack;

public class ReverseWordsInAString{
    public static void main(String[] args) {
       Solution solution = new ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        char[] r = new char[s.length()];
        int rd = 0;
        for(int i = s.length()-1;i>=0;i--){
            char c = s.charAt(i);
            if(stack.isEmpty() && c == ' '){
                continue;
            }else if(c == ' '){
                while (!stack.isEmpty()){
                    r[rd++] = stack.pop();
                }
                r[rd++] = ' ';
                continue;
            }
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()){
            r[rd++] = stack.pop();
        }
        return String.valueOf(r).trim();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}