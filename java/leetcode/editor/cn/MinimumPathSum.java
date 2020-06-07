//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划

  
package leetcode.editor.cn;
public class MinimumPathSum{
    public static void main(String[] args) {
        Solution solution = new MinimumPathSum().new Solution();
        int[][] s = new int[2][3];
        s[0] = new int[]{1,2,5};
        s[1] = new int[]{3,2,1};
        System.out.println(solution.minPathSum(s));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int[] ints = grid[0];
        int[][] dp = new int[grid.length][ints.length];
        dp[0][0] = grid[0][0];
        for (int i=1;i< ints.length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int j = 1; j < grid.length; j++) {
            dp[j][0] = dp[j-1][0] + grid[j][0];
        }
        for (int i=1;i< grid.length;i++){
            for (int j = 1; j < ints.length; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[grid.length-1][ints.length-1];
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}
