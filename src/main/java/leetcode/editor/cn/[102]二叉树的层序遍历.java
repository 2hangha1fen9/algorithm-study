/**
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 

 

 示例 1： 
 
 
输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
 

 示例 2： 

 
输入：root = [1]
输出：[[1]]
 

 示例 3： 

 
输入：root = []
输出：[]
 

 

 提示： 

 
 树中节点数目在范围 [0, 2000] 内 
 -1000 <= Node.val <= 1000 
 

 Related Topics 树 广度优先搜索 二叉树 👍 1673 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

class BinaryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        root.left = left;
        root.right = right;
        System.out.println(Arrays.toString(solution.levelOrder(root).toArray()));
    }
    static  public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //首节点入队
        queue.add(root);
        List<Integer> roots = new ArrayList<>();
        roots.add(root.val);
        result.add(roots);
        while (!queue.isEmpty()){
            //当前层的节点数
            int nodeCount = queue.size();
            List<Integer> nodes = new ArrayList<>();
            //遍历当前层节点
            while (nodeCount-- > 0){
                TreeNode node = queue.remove();
                if(node.left != null){
                    queue.add(node.left);
                    nodes.add(node.left.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                    nodes.add(node.right.val);
                }
            }
            if(nodes.size() > 0){
                result.add(nodes);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
