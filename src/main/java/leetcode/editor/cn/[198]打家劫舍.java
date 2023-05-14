/**
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小
偷闯入，系统会自动报警。 

 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 

 

 示例 1： 

 
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。 

 示例 2： 

 
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 

 

 提示： 

 
 1 <= nums.length <= 100 
 0 <= nums[i] <= 400 
 

 Related Topics 数组 动态规划 👍 2557 👎 0

*/

package leetcode.editor.cn;
class HouseRobber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0; //这一间房子没偷
        dp[0][1] = nums[0]; //这一间房子偷了
        for(int i = 1;i < dp.length;i++){
            //如果今天没偷，就看昨天没偷的最大价值和昨天偷了的最大价值
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            //今天偷了，就是昨天没偷的最大价值加上今天的
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        //最后取最大值即可
        return Math.max(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
