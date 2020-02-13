//给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索

  
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
       Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //BFS宽度优先
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        //使用队列，保证新增的在后面，旧的在前面，不会使新增的item影响旧item的去除。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){//queue在每层迭代时，都会去除本层并加入下一层。如果为空，表示迭代结束
            //记录上层节点数量
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i=0;i<size;i++){
                TreeNode remove = queue.remove();
                level.add(remove.val);
                if(remove.left != null){
                    queue.add(remove.left);
                }
                if(remove.right != null){
                    queue.add(remove.right);
                }
            }
            res.add(level);
        }
        return res;


        
    }

}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}