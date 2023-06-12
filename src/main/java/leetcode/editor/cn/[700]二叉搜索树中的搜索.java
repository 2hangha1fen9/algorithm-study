//给定二叉搜索树（BST）的根节点
// root 和一个整数值
// val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回
// null 。 
//
// 
//
// 示例 1: 
//
// 
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// 示例 2: 
// 
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 数中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
//
// Related Topics 树 二叉搜索树 二叉树 👍 408 👎 0


package leetcode.editor.cn;

class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.right = new TreeNode(7);
        System.out.println(solution.searchBST(node,3).val);
    }

    static class TreeNode {
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
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null){
                return null;
            }
            return root.val == val ? root : searchBST(root.val > val ? root.left : root.right,val);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}