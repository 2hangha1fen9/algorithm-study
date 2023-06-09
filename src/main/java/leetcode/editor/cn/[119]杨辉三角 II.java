//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 492 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangleIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(1));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        result.add(init);
        if(rowIndex == 0){
            return init;
        }
        for(int i = 1;i <= rowIndex;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1;j < i;j++){
                //将上一行的左上方元素和正上方相加
                int left = result.get(i - 1).get(j - 1);
                int right = result.get(i - 1).get(j);
                row.add(left + right);
            }
            row.add(1); //每一行尾为1
            result.add(row);
        }
        return result.get(rowIndex);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}