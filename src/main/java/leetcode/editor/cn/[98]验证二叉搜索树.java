/**
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。 

 有效 二叉搜索树定义如下： 

 
 节点的左子树只包含 小于 当前节点的数。 
 节点的右子树只包含 大于 当前节点的数。 
 所有左子树和右子树自身必须也是二叉搜索树。 
 

 

 示例 1： 
 
 
输入：root = [2,1,3]
输出：true
 

 示例 2： 
 
 
输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
 

 

 提示： 

 
 树中节点数目范围在[1, 10⁴] 内 
 -2³¹ <= Node.val <= 2³¹ - 1 
 

 Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 2002 👎 0

*/

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

class ValidateBinarySearchTree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(5,new TreeNode(1),new TreeNode(4,new TreeNode(3),new TreeNode(6)));

        System.out.println(solution.isValidBST(root));
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
    public boolean isValidBST_1(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode node,long lower,long upper){
        if(node == null){
            return true;
        }
        if(node.val <= lower || node.val >= upper){
            return false;
        }
        return dfs(node.left,lower,node.val) && dfs(node.right,node.val,upper);
    }

    //中序遍历
    TreeNode prev;
    public boolean isValidBST(TreeNode root){
        if(root == null){
            return true;
        }
        //访问左子树
        if(!isValidBST(root.left)){
            return false;
        }
        //访问当前节点：如果当前节点小于等于中序遍历的前一个节点直接返回false。
        if(prev != null && prev.val >= root.val){
            return false;
        }
        prev = root;
        //访问右子树
        if(!isValidBST(root.right)){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
