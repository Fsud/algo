//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 案例: 
//
// 
//s = "leetcode"
//返回 0.
//
//s = "loveleetcode",
//返回 2.
// 
//
// 
//
// 注意事项：您可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i=0;i<s.length();i++){
                Integer orDefault = map.getOrDefault(s.charAt(i),0);
                map.put(s.charAt(i),++orDefault);
            }
            for (int i=0;i<s.length();i++){
                Integer integer = map.get(s.charAt(i));
                if(integer == 1){
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
