//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] a = { 0,1,3,2,0};
        solution.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 想到了双指针，但是没想到可以直接交换
     */
    class Solution {
        public void moveZeroes(int[] nums) {
            int p = 0;
            int count = 0;
            for (int i=0;i<nums.length;i++) {
                if(nums[i]==0){
                    count++;
                }else{
                    if(p!= i){
                        nums[p] = nums[i];
                    }
                    p++;
                }
            }
            for (int i= nums.length-1;i>nums.length-count-1;i--){
                nums[i] = 0;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
