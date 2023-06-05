/**
给你一个字符串 s，找到 s 中最长的回文子串。 

 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 

 

 示例 1： 

 
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
 

 示例 2： 

 
输入：s = "cbbd"
输出："bb"
 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 仅由数字和英文字母组成 
 

 Related Topics 字符串 动态规划 👍 6544 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

class LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("aaaa"));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //暴力枚举
    public String longestPalindrome_1(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 1;
        int maxIndex = 0;
        for(int i = 0;i < chars.length - 1;i++){
            for(int j = i + 1;j < chars.length;j++){
                //遍历所有子串，获取最大子串长度
                if(validPalindrome(chars,i,j) && (j - i + 1) > maxLength){
                    maxLength = j - i + 1;
                    maxIndex = i;
                }
            }
        }
        return s.substring(maxIndex,maxIndex + maxLength);
    }
    public boolean validPalindrome(char[] s,int start,int end) {
        while (start < end){
             if(s[start] != s[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //中心扩散
    public String longestPalindrome_2(String s){
        char[] chars = s.toCharArray();
        int maxLength = 1;
        int maxIndex = 0;
        for(int i = 0;i < chars.length - 1;i++){
            //奇数为中心的最大回文长度
            int oddLen = expandCenter(chars,i,i);
            //偶数为中心的最大回文长度
            int evenLen = expandCenter(chars,i,i + 1);
            //取最大长度
            int curMaxLength = Math.max(oddLen,evenLen);
            if(curMaxLength > maxLength){
                maxLength = curMaxLength;
                //获取回文串初始角标
                maxIndex = i - (curMaxLength - 1) / 2;
            }
        }
        return s.substring(maxIndex,maxIndex + maxLength);
    }
    public int expandCenter(char[] s,int start,int end){
        while (start >= 0 && end < s.length){
            if(s[start] == s[end]){
                start--;
                end++;
            }
            else{
                break;
            }
        }
        return end - start - 1;
    }

    //动态规划
    public String longestPalindrome(String s){
        char[] chars = s.toCharArray();
        //dp[i][j] 代表[i,j]是否数回文串
        boolean[][] dp = new boolean[chars.length][chars.length];
        //初始i==j的情况(两个指针指向同一个元素)
        for(int i = 0;i < dp.length;i++){
            dp[i][i] = true;
        }
        int maxLength = 1;
        int maxIndex = 0;
        //上三角遍历，保证所有dp转移能获取到值
        for(int i = chars.length - 1;i >= 0;i--){
            for(int j = i;j < chars.length;j++){
                if(chars[i] == chars[j]){
                    //长度为2且两个相同，就是回文串
                    if(j - i < 3){
                        dp[i][j] = true;
                    }
                    //两端相同的情况下，在判断i,j缩放的情况是否是回文串
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //i,j是回文串，更新最大长度
                if(dp[i][j] && j - i + 1 > maxLength){
                    maxLength = j - i + 1;
                    maxIndex = i;
                }
            }
        }
        return s.substring(maxIndex,maxIndex + maxLength);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
