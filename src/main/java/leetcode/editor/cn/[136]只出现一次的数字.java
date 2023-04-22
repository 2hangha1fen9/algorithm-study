/**
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 

 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。 

 
 
 
 
 

 示例 1 ： 

 
输入：nums = [2,2,1]
输出：1
 

 示例 2 ： 

 
输入：nums = [4,1,2,1,2]
输出：4
 

 示例 3 ： 

 
输入：nums = [1]
输出：1
 

 

 提示： 

 
 1 <= nums.length <= 3 * 10⁴ 
 -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
 除了某个元素只出现一次以外，其余每个元素均出现两次。 
 

 Related Topics 位运算 数组 👍 2831 👎 0

*/

package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

class SingleNumber{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{2,2,1}));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 异或运算，相异为真，相同为假，所以 a^a = 0 ;0^a = a
    // 因为异或运算 满足交换律 a^b^a = a^a^b = b 所以数组经过异或运算，单独的值就剩下了
    public int singleNumber(int[] nums) {
        int num = 0;
        for(int n : nums){
            num ^= n;
        }
        return num;
    }
    public int singleNumber_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                //如果添加失败，说明这个值
                //在集合Set中存在，我们要
                //把他给移除掉
                set.remove(num);
            }
        }
        //最终集合Set中只有一个元素，我们直接返回
        return (int) set.toArray()[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
