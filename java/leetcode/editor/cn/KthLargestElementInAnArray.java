//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法

  
package leetcode.editor.cn;
public class KthLargestElementInAnArray{
  public static void main(String[] args) {
       Solution solution = new KthLargestElementInAnArray().new Solution();
      int[] ints = { 3, 2, 1,8,7,6,5,4,9 };
      System.out.println(solution.findKthLargest(ints,3));
  }
  //时间复杂度O(n),空间复杂度O(1)
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //将“第K大”语义转换为有序坐标target
        int target = nums.length - k;
        int left = 0;
        int right = nums.length-1;
        while(true){
            int q = partition(nums,left,right);
            if(q == target){
                return nums[q];
            }else if (q < target){
                left = q + 1;
            }else{
                right = q - 1;
            }
        }
    }



      private int partition(int[] nums, int p,int r) {
        int pivot = nums[r];
        int i = p;
          for (int j = p; j < r; j++) {
              if(nums[j] < pivot){
                  int tmp = nums[j];
                  nums[j] = nums[i];
                  nums[i] = tmp;
                  i++;
              }
          }
            int tmp = nums[r];
          nums[r] = nums[i];
          nums[i] = tmp;
          return i;
      }

  }

//leetcode submit region end(Prohibit modification and deletion)

}