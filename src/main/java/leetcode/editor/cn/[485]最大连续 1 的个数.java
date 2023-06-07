/**
给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 

 

 示例 1： 

 
输入：nums = [1,1,0,1,1,1]
输出：3
解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 

 示例 2: 

 
输入：nums = [1,0,1,1,0,1]
输出：2
 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 nums[i] 不是 0 就是 1. 
 

 Related Topics 数组 👍 390 👎 0

*/

package leetcode.editor.cn;
class MaxConsecutiveOnes{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(new int[]{1,0,1,0,1}));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (true){
            //越界停止循环
            if(right == nums.length){
                max = Math.max(max,right - left);
                break;
            }
            //两个指针都为1右指针进位继续试探
            if(nums[left] == 1 && nums[right] == 1){
                right++;
            }
            //如果试探的值不为1者两个指针同时进位，并判断最大连续
            else if(nums[right] != 1){
                max = Math.max(max,right - left);
                left = ++right;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
