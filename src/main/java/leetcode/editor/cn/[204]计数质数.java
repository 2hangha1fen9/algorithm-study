//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
//
// Related Topics 数组 数学 枚举 数论 👍 1060 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

class CountPrimes{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(10));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        for(int i = 2;i < n;i++){
            if(isPrimes[i]){
                count++;
                if((long) i * i <= n){
                    for(int j = i * i;j < n;j += i){
                        isPrimes[j] = false;
                    }
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}