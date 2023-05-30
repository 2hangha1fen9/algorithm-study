/**
以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 
一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 

 

 示例 1： 

 
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 

 示例 2： 

 
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 

 

 提示： 

 
 1 <= intervals.length <= 10⁴ 
 intervals[i].length == 2 
 0 <= starti <= endi <= 10⁴ 
 

 Related Topics 数组 排序 👍 1900 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,9},{2,5},{19,20},{10,11},{12,20},{0,3},{0,1},{0,2}};
        solution.merge(intervals);
        System.out.println(intervals);
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(i -> i[0]));
        List<int[]> merged = new ArrayList<>();
        for(int i = 0;i < intervals.length;i++){
            int l = intervals[i][0];
            int r = intervals[i][1];
            // 如果列表为空，或者当前区间与上一区间不重合，直接添加
            if(merged.size() == 0 || merged.get(merged.size() - 1)[1] < l){
                merged.add(intervals[i]);
            }
            else{
                //否则的话，我们就可以与上一区间进行合并
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1],r);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
