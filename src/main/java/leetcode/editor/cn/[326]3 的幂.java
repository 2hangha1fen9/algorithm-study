//给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3ˣ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 27
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 9
//输出：true
// 
//
// 示例 4： 
//
// 
//输入：n = 45
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不使用循环或者递归来完成本题吗？ 
//
// Related Topics 递归 数学 👍 295 👎 0


package leetcode.editor.cn;
class PowerOfThree{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPowerOfThree(1));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        // 如果不是三的倍数，肯定就不是3的幂了
        if(n%3 != 0){
            return false;
        }
        // 如果整除3后的值不是三的倍数，就不是3的幂了
        // 如果n = 3了，那么肯定是三的幂了
        while (n != 3){
            if(n % 3 != 0){
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}