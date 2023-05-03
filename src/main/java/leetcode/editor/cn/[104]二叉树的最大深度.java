/**
给定一个二叉树，找出其最大深度。 

 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 

 说明: 叶子节点是指没有子节点的节点。 

 示例： 给定二叉树 [3,9,20,null,null,15,7]， 

     3
   / \
  9  20
    /  \
   15   7 

 返回它的最大深度 3 。 

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1594 👎 0

*/

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class MaximumDepthOfBinaryTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        
    }

    static  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
  }
static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //递归
    public int maxDepth_1(TreeNode root) {
       if(root == null){
           return 0;
       }
       //左子节点深度
       int left = maxDepth(root.left);
       //右子节点深度
       int right = maxDepth(root.right);
       //当前节点最大深度
       return Math.max(left,right) + 1;
    }

    //BFS
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int layer = 0;
        //首节点入队
        queue.add(root);
        //遍历二叉树的每一层
        while (!queue.isEmpty()){
            //层级自增
            layer++;
            //当前层节点数
            int nodeCount = queue.size();
            //遍历当前层
            while (nodeCount-- > 0){
                //队首元素出队
                TreeNode node = queue.remove();
                //将当前节点的子元素依次入队
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return layer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
