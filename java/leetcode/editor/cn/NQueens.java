//n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
//
// 
//
// 上图为 8 皇后问题的一种解法。 
//
// 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。 
//
// 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 示例: 
//
// 输入: 4
//输出: [
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
//解释: 4 皇后问题存在两个不同的解法。
// 
// Related Topics 回溯算法


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> res = new ArrayList<>();
        int[] result;
        int n = 0;

        public List<List<String>> solveNQueens(int n) {
            result = new int[n];
            this.n = n;
            calNQueue(0);
            return res;
        }

        /**
         * 计算第row行
         * @param row
         */
        private void calNQueue(int row) {
            if (row == n) {
                //寻找到了最后一层，找到了一种正确结果，保存
                res.add(trasn(result));
                return;
            }
            //对第row行的每一列，尝试是否满足需求
            //如果满足需求，则进入下一行继续判断
            //PS：向下尝试的过程中，尝试结果存入result[]中不会影响其他的分支
            for (int column = 0; column < n; ++column) {
                if (isProv(row, column)) {
                    result[row] = column;
                    calNQueue(row + 1);
                }
            }

        }

        /**
         * 是否满足皇后不相见。
         * 从最下一行开始向上检查。leftP和rightP作为斜线上的指针。
         * @param row
         * @param column
         * @return
         */
        private boolean isProv(int row, int column) {
            int leftP = column - 1;
            int rightP = column + 1;
            for (int i = row - 1; i >= 0; i--) {
                if (result[i] == column) {
                    return false;
                }
                if (leftP >= 0) {
                    if (result[i] == leftP) {
                        return false;
                    }
                }
                if (rightP <= n - 1) {
                    if (result[i] == rightP) {
                        return false;
                    }
                }
                leftP--;
                rightP++;
            }
            return true;
        }

        //不重要
        private List<String> trasn(int[] result) {
            List<String> r = new ArrayList<>();
            for (int i : result) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    temp.append(".");
                }
                temp.append("Q");
                for (int j = i + 1; j < n; j++) {
                    temp.append(".");
                }
                r.add(temp.toString());
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
