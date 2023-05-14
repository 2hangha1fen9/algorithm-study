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
    //超时
    public int countPrimes_1(int n) {
        int count = 0;
        int i = 2;
        while (i < n){
            if(isPrime(i)){
                count++;
            }
            i++;
        }
        return count;
    }
    public boolean isPrime(int n){
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    //埃氏筛
    public int countPrimes(int n){
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes,true);
        int count = 0;
        for(int i = 2;i < n;i++){
            if(isPrimes[i]){
                count++;
                //如果这个数是质数则它的倍数都不是2i,3i,4i
                if((long)i * i < n){
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