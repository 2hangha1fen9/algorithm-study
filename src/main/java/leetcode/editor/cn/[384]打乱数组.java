/**
给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。 

 实现 Solution class: 

 
 Solution(int[] nums) 使用整数数组 nums 初始化对象 
 int[] reset() 重设数组到它的初始状态并返回 
 int[] shuffle() 返回数组随机打乱后的结果 
 

 

 示例 1： 

 
输入
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
输出
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

解释
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1,
 2]
solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 

 

 提示： 

 
 1 <= nums.length <= 50 
 -10⁶ <= nums[i] <= 10⁶ 
 nums 中的所有元素都是 唯一的 
 最多可以调用 10⁴ 次 reset 和 shuffle 
 

 Related Topics 数组 数学 随机化 👍 335 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class ShuffleAnArray{
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.reset()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[] nums;
    private Random random;
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    public int[] reset() {
        return this.nums;
    }
    
    public int[] shuffle() {
        if (nums == null)
            return null;
        int[] result = nums.clone();
        for(int i = 1;i < result.length;i++){
            int r = random.nextInt(i + 1); //等可能关键
            swap(result,i,r);
        }
        return result;
    }

    private void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
