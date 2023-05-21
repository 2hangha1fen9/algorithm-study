/**
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 

 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 

 

 

 示例 1: 

 
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 

 示例 2: 

 
输入: numRows = 1
输出: [[1]]
 

 

 提示: 

 
 1 <= numRows <= 30 
 

 Related Topics 数组 动态规划 👍 998 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class PascalsTriangle{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        result.add(init);
        if(numRows == 1){
            return result;
        }
        for (int i = 1;i < numRows;i++){
            List<Integer> row = new ArrayList<>();
            row.add(1); //每一行首为1
            for(int j = 1;j < i;j++){
                //将上一行的左上方元素和正上方相加
                int left = result.get(i - 1).get(j - 1);
                int right = result.get(i - 1).get(j);
                row.add(left + right);
            }
            row.add(1); //每一行尾为1
            result.add(row);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
