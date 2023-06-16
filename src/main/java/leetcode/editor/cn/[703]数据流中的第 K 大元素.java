//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 10⁴ 
// 0 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁴ <= val <= 10⁴ 
// 最多调用 add 方法 10⁴ 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
//
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 434 👎 0


package leetcode.editor.cn;

class KthLargestElementInAStream {
    public static void main(String[] args) {
        KthLargest solution = new KthLargest(3, new int[]{4, 5, 8, 2});
        solution.add(3);
        solution.add(5);
        solution.add(10);
        solution.add(9);
        solution.add(4);

    }

    static class TreeNode {
        int val;
        int cnt;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
            this.cnt = 1;
        }
    }

    static
//leetcode submit region begin(Prohibit modification and deletion)
    class KthLargest {
        int K = 0;
        TreeNode root = null;

        public KthLargest(int k, int[] nums) {
            K = k;

            for (int i = 0; i < nums.length; ++i) {
                root = insert(root, nums[i]);
            }
        }

        TreeNode insert(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insert(root.left, val);
            } else {
                root.right = insert(root.right, val);
            }
            int lcnt = root.left == null ? 0 : root.left.cnt;
            int rcnt = root.right == null ? 0 : root.right.cnt;
            root.cnt = lcnt + rcnt + 1;
            return root;
        }

        public int add(int val) {
            root = insert(root, val);
            return find(root, K);
        }

        int find(TreeNode root, int k) {
            int lcnt = root.left == null ? 0 : root.left.cnt;
            int rcnt = root.right == null ? 0 : root.right.cnt;
            if (root.cnt - lcnt == k) {
                return root.val;
            } else if (root.cnt - lcnt < k) {
                return find(root.left, k - rcnt - 1);
            } else {
                return find(root.right, k);
            }
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}