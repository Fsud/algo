//现在你总共有 n 门课需要选，记为 0 到 n-1。 
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1] 
//
// 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。 
//
// 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 示例 1: 
//
// 输入: 2, [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
//     因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 说明: 
//
// 
// 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。 
// 你可以假定输入的先决条件中没有重复的边。 
// 
//
// 提示: 
//
// 
// 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。 
// 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。 
// 
// 拓扑排序也可以通过 BFS 完成。 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序

  
package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class CourseScheduleIi{
    public static void main(String[] args) {
        Solution solution = new CourseScheduleIi().new Solution();
    }
    //DAG图中的「拓扑排序」问题
    //BFS解法是一种逆向思想。从入度值为0的开始记录，即得到最终结果。

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //队列作为BFS的存储工具。只有入度为0的节点才会入队。
        Queue<Integer> queue = new LinkedList();
        //input数组记录每个节点的入度数。下标代表节点，value代表入度值
        int[] input = new int[numCourses];
        int[] res = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            input[prerequisite[0]]++;
        }
        //将入度为0的课程先入队，因为入度为0的课程相当于不依赖前置课程。从这些课程开始遍历
        for (int i = 0; i < numCourses; i++) {
            if(input[i] == 0){
                queue.offer(i);
            }
        }
        //循环将队列中的元素移出，将它指向的节点的入度减一。再判断节点入度是否已为0，为0将其入队。
        int idx = 0;
        while (!queue.isEmpty()){
            int p = queue.poll();
            res[idx++] = p;

            for (int[] prerequisite : prerequisites) {
                if(prerequisite[1] == p) {
                    input[prerequisite[0]]--;
                    if(input[prerequisite[0]]==0){
                        queue.offer(prerequisite[0]);
                    }
                }
            }
        }

        if(idx != numCourses){
            return new int[]{};
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
