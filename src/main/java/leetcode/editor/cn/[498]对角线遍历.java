/**
给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。 

 

 示例 1： 
 
 
输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,4,7,5,3,6,8,9]
 

 示例 2： 

 
输入：mat = [[1,2],[3,4]]
输出：[1,2,3,4]
 

 

 提示： 

 
 m == mat.length 
 n == mat[i].length 
 1 <= m, n <= 10⁴ 
 1 <= m * n <= 10⁴ 
 -10⁵ <= mat[i][j] <= 10⁵ 
 

 Related Topics 数组 矩阵 模拟 👍 448 👎 0

*/

package leetcode.editor.cn;
class DiagonalTraverse{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1,2,3,4,5,6,7,8,9},
                       {3,4,5,4,5,3,5,6,4},
                       {4,5,6,4,2,1,1,3,4},
                       {5,6,3,3,2,3,4,5,3}};
        solution.findDiagonalOrder(mat);
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int r = 0;

        for (int i = 0; i < m + n; i++) {
            // 偶数行上到下遍历
            if (i % 2 == 0) {
                int y = Math.min(i, m - 1);
                int x = i - y;
                while (y >= 0 && x < n) {
                    result[r++] = mat[y--][x++];
                }

            }
            // 奇数行从下往上遍历
            else {
                int x = Math.min(i, n - 1);
                int y = i - x;
                System.out.println(y + ":" + x);
                while (x >= 0 && y < m) {
                    result[r++] = mat[y++][x--];
                }

            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
