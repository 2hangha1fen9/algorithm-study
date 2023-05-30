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
        
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length * mat[0].length];
        result[0] = mat[0][0];
        for(int l = 1;l)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
