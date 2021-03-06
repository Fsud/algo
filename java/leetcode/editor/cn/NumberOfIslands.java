//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//11110
//11010
//11000
//00000
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//11000
//11000
//00100
//00011
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集
//DFS遍历。和二叉树的区别是需要注意的点。即向上下左右四个方向遍历，并且需要考虑重复遍历的问题，所以遍历过的节点需要标记为'2'

package leetcode.editor.cn;

public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numIslands(char[][] grid) {
            if (grid == null ||grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int res = 0;
            int rn = grid.length;
            int cn = grid[0].length;
            for (int i = 0; i < rn; i++) {
                for (int j = 0; j < cn; j++) {
                    if (grid[i][j] == '1') {
                        res++;
                        dfs(grid, i - 1, j,rn,cn);
                        dfs(grid, i + 1, j,rn,cn);
                        dfs(grid, i, j - 1,rn,cn);
                        dfs(grid, i, j + 1,rn,cn);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] grid, int i, int j,int rn,int cn) {
            if(i < 0 || j < 0 || i == rn || j == cn){
                return;
            }
            if(grid[i][j] == '1'){
                grid[i][j] = '2';
                dfs(grid, i - 1, j,rn,cn);
                dfs(grid, i + 1, j,rn,cn);
                dfs(grid, i, j - 1,rn,cn);
                dfs(grid, i, j + 1,rn,cn);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
