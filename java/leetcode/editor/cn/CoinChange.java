//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 示例 1: 
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3 
//解释: 11 = 5 + 5 + 1 
//
// 示例 2: 
//
// 输入: coins = [2], amount = 3
//输出: -1 
//
// 说明: 
//你可以认为每种硬币的数量是无限的。 
// Related Topics 动态规划

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange{
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] array = {2};
        System.out.println(solution.coinChange(array,3));
    }
    //官方解答中的 动态规划-自上而下
    //状态转移方程： f(n) = 1 + min(f(n-c1),f(n-c2)...f(n-cn))
    //使用备忘录存储重复子问题
    //aymy终于做了一道DP题了，不容易
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        private int[] coins;
        private int[] mem;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.mem = new int[amount+1];
        int f = f(amount);
        return f;
    }

    public int f(int n){
        // 子问题终结
        if(n==0){
            return 0;
        }
        //子问题没有解答，返回-1
        if(n < 0){
            return -1;
        }
        if(mem[n] != 0){
            return mem[n];
        }
        //标记没有任何的子问题有效时
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if(n == coin){
                return 1;
            }
            if(n < coin){
                continue;
            }
            int fc = f(n-coin);
            //子问题不为-1，说明有解，min计算
            if(fc != -1){
                min = Math.min(min,fc);
            }
        }
        //为Integer.MAX_VALUE表明本问题所有子问题均无解，返回-1，否则按公式返回。

        int value = (min == Integer.MAX_VALUE)?-1:1 + min;
        mem[n] = value;
        return value;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
