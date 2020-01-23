  //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法
  
  package leetcode.editor.cn;
  public class MajorityElement{
      public static void main(String[] args) {
           Solution solution = new MajorityElement().new Solution();
          System.out.println(solution.majorityElement(new int[]{3,2,3}));
      }
      

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1,candidate = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != candidate){
                if(count == 0){
                    candidate = nums[i];
                    count = 1;
                }else{
                    count--;
                }
            }else{
                count++;
            }
        }
        return candidate;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
//学到了：摩尔投票法
      //还可以使用：排序取中值，map等
  }
