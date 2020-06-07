//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层次遍历如下： 
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索

//由于锯齿形层次遍历，不能简单的使用Queue了。锯齿形遍历时，下层节点的添加顺序和便利顺序实际上是相反的，所以可以使用双栈的方式。
//见官方解题的第一种。有个细节，就是复用队列的话，需要考虑结束标识，可以手动在最后一个元素加入null做标识。
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeZigzagLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            Stack<TreeNode> even = new Stack();
            Stack<TreeNode> odd = new Stack();
            even.push(root);
            for (int i = 0; !even.isEmpty() || !odd.isEmpty(); i++) {
                List<Integer> cur = new ArrayList();
                if(i % 2 == 0){
                    while(!even.isEmpty()){
                        TreeNode pop = even.pop();
                        cur.add(pop.val);
                        if(pop.left != null){
                            odd.push(pop.left);
                        }
                        if(pop.right != null){
                            odd.push(pop.right);
                        }
                    }
                }else{
                    while(!odd.isEmpty()){
                        TreeNode pop = odd.pop();
                        cur.add(pop.val);
                        if(pop.right != null){
                            even.push(pop.right);
                        }
                        if(pop.left != null){
                            even.push(pop.left);
                        }
                    }
                }
                res.add(cur);
            }
            return res;

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
