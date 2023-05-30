/**
编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 

 

 示例 1： 

 输入：
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出：
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
 

 示例 2： 

 输入：
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出：
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
 

 Related Topics 数组 哈希表 矩阵 👍 167 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

class ZeroMatrixLcci{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] map = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.setZeroes(map);
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> zeroLocation = new ArrayList<>();
        for(int y = 0;y < matrix.length;y++){
            for(int x = 0;x < matrix[y].length;x++){
                if(matrix[y][x] == 0) {
                    zeroLocation.add(new int[]{y,x});
                }
            }
        }
        for(int[] l : zeroLocation){
            int y = l[0];
            int x = l[1];
            //处理当前行
            Arrays.fill(matrix[y],0);
            //处理上下
            matrix[matrix.length / 2][x] = 0;
            for (int i = 0;i < matrix.length / 2;i++){
                matrix[i][x] = 0;
                matrix[matrix.length - i - 1][x] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
