/**
编写一个函数来查找字符串数组中的最长公共前缀。 

 如果不存在公共前缀，返回空字符串 ""。 

 

 示例 1： 

 
输入：strs = ["flower","flow","flight"]
输出："fl"
 

 示例 2： 

 
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。 

 

 提示： 

 
 1 <= strs.length <= 200 
 0 <= strs[i].length <= 200 
 strs[i] 仅由小写英文字母组成 
 

 Related Topics 字典树 字符串 👍 2758 👎 0

*/

package leetcode.editor.cn;
class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String prefiex = strs[0];
        for(String str : strs){
            while (!str.startsWith(prefiex)){
                if(prefiex.length() == 0){
                    return "";
                }
                //公共前缀不匹配就让它变短,剩下的就是最长的公共序列
                prefiex = prefiex.substring(0,prefiex.length() - 1);
            }
        }
        return prefiex;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
