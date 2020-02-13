//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
// Related Topics 堆 Sliding Window

  
package leetcode.editor.cn;

import java.util.ArrayDeque;

public class SlidingWindowMaximum{
  public static void main(String[] args) {
       Solution solution = new SlidingWindowMaximum().new Solution();
      System.out.println(solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3));
  }
  

//相当于维护了一个特殊的队列，首位元素是最大的最大的。
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if( nums == null || nums.length == 0)//判断传进来的是否为int数组，int数组是否为空，int数组是否没有数据
            return new int[0];

        ArrayDeque<Integer> deque = new ArrayDeque<>();//存储数字在数组中的下标。
        int[] result = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            //每当新数进来，判断队头下标是否在窗口外，如果在窗口外(i-k)，则移除
            if(!deque.isEmpty() && deque.peekFirst() == i -k){
                deque.removeFirst();
            }
            //对于新数，从队尾依次遍历，判断如果小于新数，则进行出队
            while (!deque.isEmpty() && nums[deque.peekLast()]< nums[i])
                deque.removeLast();
            //新数队尾入队
            deque.offerLast(i);
            //队列头赋值到结果数组
            if(i >= k-1)
                result[i-k+1] = nums[deque.peekFirst()] ;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}