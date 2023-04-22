/**
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 

 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 

 你可以假设除了整数 0 之外，这个整数不会以零开头。 

 

 示例 1： 

 
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
 

 示例 2： 

 
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
 

 示例 3： 

 
输入：digits = [0]
输出：[1]
 

 

 提示： 

 
 1 <= digits.length <= 100 
 0 <= digits[i] <= 9 
 

 Related Topics 数组 数学 👍 1219 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

class PlusOne{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        //先加一
        digits[digits.length - 1] += 1;
        //进位值
        int carry = 0;
        //处理进位
        for(int i = digits.length - 1;i >= 0;i--){
            int value = digits[i] + carry;
            carry = value / 10;
            digits[i] = value % 10;
        }
        //如果还有进位值则在最前面加一
        if(carry == 1){
            // digits 中所有的元素均为 9
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
