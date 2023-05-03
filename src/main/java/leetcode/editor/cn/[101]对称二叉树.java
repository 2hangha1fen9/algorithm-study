/**
给你一个二叉树的根节点 root ， 检查它是否轴对称。 

 

 示例 1： 
 
 
输入：root = [1,2,2,3,4,4,3]
输出：true
 

 示例 2： 
 
 
输入：root = [1,2,2,null,3,null,3]
输出：false
 

 

 提示： 

 
 树中节点数目在范围 [1, 1000] 内 
 -100 <= Node.val <= 100 
 

 

 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2409 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2,new TreeNode(9),new TreeNode(3));
        TreeNode right = new TreeNode(2,new TreeNode(3),new TreeNode(7));
        root.left = left;
        root.right = right;
        System.out.println(solution.isSymmetric(root));
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
    //dfs
    public boolean isSymmetric_1(TreeNode root) {
        if(root == null){
            return true;
        }
        //从两个子节点开始判断
        return juege(root.left,root.right);
    }

    public boolean juege(TreeNode left,TreeNode right){
        //如果左右子节点都为空，说明当前节点是叶子节点，返回true
        if(left == null && right == null){
            return true;
        }
        //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
        if(left == null || right == null || left.val != right.val){
            return false;
        }
        //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
        return juege(left.left,right.right) && juege(left.right,right.left);
    }

    //bfs
    public boolean isSymmetric(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //左子节点和右子节点同时入队
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            //每两个出队
            TreeNode left = queue.remove();
            TreeNode right = queue.remove();
            //如果都为空继续循环
            if(left == null && right == null){
                continue;
            }
            //如果一个为空一个不为空，说明不是对称的，直接返回false
            if(left == null ^ right == null){
                return false;
            }
            //如果这两个值不相同，也不是对称的，直接返回false
            if(left.val != right.val){
                return false;
            }
            //这里要记住入队的顺序，他会每两个两个的出队。
            //左子节点的左子节点和右子节点的右子节点同时
            //入队，因为他俩会同时比较。
            //左子节点的右子节点和右子节点的左子节点同时入队，
            //因为他俩会同时比较
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
