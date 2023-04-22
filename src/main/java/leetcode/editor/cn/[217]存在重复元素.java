/**
给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

 

 示例 1： 

 
输入：nums = [1,2,3,1]
输出：true 

 示例 2： 

 
输入：nums = [1,2,3,4]
输出：false 

 示例 3： 

 
输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 Related Topics 数组 哈希表 排序 👍 995 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //依次遍历超时
    public boolean containsDuplicate_1(int[] nums) {
        for(int i = 0;i < nums.length - 1;i++){
            for(int j = i + 1;j < nums.length;j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
    //执行耗时:19 ms,击败了41.23% 的Java用户
    //内存消耗:55.5 MB,击败了28.70% 的Java用户
    public boolean containsDuplicate_2(int[] nums) {
        //将数据排序
        Arrays.sort(nums);
        //比较相邻数据
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] == nums[i + 1]){
                return true;
            }
        }
        return false;
    }
    //哈希表
    public boolean containsDuplicate_3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //依次存入并判断
        for(int n : nums){
            set.add(n);
        }
        return set.size() != nums.length;
    }
    public boolean containsDuplicate(int[] nums) {
        int max=nums[0],min=nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                continue;
            }
            if(nums[i]<min){
                min=nums[i];
                continue;
            }
            for(int j=0;j<i;j++){
                if(nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
