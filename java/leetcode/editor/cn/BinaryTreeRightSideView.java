//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeRightSideView().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     */
    class Solution {
        List<Integer> res = new ArrayList<>();
        public List<Integer> rightSideView(TreeNode root) {
            if(root == null){
                return res;
            }
            fs(root,0);
            return res;
        }

        private void fs(TreeNode node, int i) {
            if(res.size()-1 < i){
                res.add(i,node.val);
            }
            if(node.right != null)
                fs(node.right,i+1);
            if(node.left != null)
                fs(node.left,i+1);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
