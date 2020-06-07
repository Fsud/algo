//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window


package leetcode.editor.cn;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), max = 0;
            //map存储每个char的下标。
            //当使用时，需要取左边界内的。所以value取出要和当前左边界对比
            Map<Character, Integer> map = new HashMap<>();
            // 左边界是代表最长不重复子串的左边界
            int left = 0;
            // 右边界不断右移
            for (int i = 0; i < n; i++) {
                if (map.containsKey(s.charAt(i))) {
                    //加1代表右移一位，从而跳过重复元素
                    left = Math.max(left, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                //计算长度需要下标差+1
                max = Math.max(max, i - left + 1);
            }
            return max;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
