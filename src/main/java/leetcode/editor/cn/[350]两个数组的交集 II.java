/**
给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数
不一致，则考虑取较小值）。可以不考虑输出结果的顺序。 

 

 示例 1： 

 
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2,2]
 

 示例 2: 

 
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[4,9] 

 

 提示： 

 
 1 <= nums1.length, nums2.length <= 1000 
 0 <= nums1[i], nums2[i] <= 1000 
 

 

 进阶： 

 
 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
 如果 nums1 的大小比 nums2 小，哪种方法更优？ 
 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
 

 Related Topics 数组 哈希表 双指针 二分查找 排序 👍 958 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

class IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect(new int[]{1,2,2,1},new int[]{2,2})));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 排序后，双指针判断交集
    public int[] intersect_1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //两个数组的指针
        int a = 0;
        int b = 0;
        List<Integer> list = new ArrayList<>();
        while (a < nums1.length && b < nums2.length){
            //
            if(nums1[a] == nums2[b]){
                list.add(nums1[a]);
                a++;
                b++;
            }else if(nums1[a] > nums2[b]){
                b++;
            }else if(nums1[a] < nums2[b]){
                a++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    // 使用hash去重
    public int[] intersect_2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        //保存两个数组并记录元素个数
        for(int n : nums1){
            map1.put(n,map1.getOrDefault(n,0) + 1);
        }
        for(int n : nums2){
            map2.put(n,map2.getOrDefault(n,0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        //统计每个元素的个数，相等则说明有交集元素
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()){
            int key = entry.getKey();
            int value1 = entry.getValue(); //获取该元素在map1的个数
            int value2 = map2.getOrDefault(key,0); //获取该元素在map2的个数
            int count = Math.min(value1,value2); //获取最小出现个数

            for(int i = 1;i <= count;i++){
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    // 双指针，节约空间版
    public int[] intersect(int[] nums1, int[] nums2) {
        //对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int a = 0; //nums1指针
        int b = 0; //nums2指针
        int l = 0; //结果长度
        while (a < nums1.length && b < nums2.length){
            //相等继续进位，结果长度加一
            if(nums1[a] == nums2[b]){
                nums1[l] = nums1[a]; //原地保存结果
                a++;
                b++;
                l++;
            }else if(nums1[a] < nums2[b]){
                a++;
            }else if(nums1[a] > nums2[b]){
                b++;
            }
        }
        return Arrays.copyOf(nums1,l);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
