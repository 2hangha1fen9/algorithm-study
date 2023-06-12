/**
给定一个字符串
 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 

 

 示例 1： 

 
输入：s = "Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"
 

 示例 2: 

 
输入： s = "God Ding"
输出："doG gniD"
 

 

 提示： 

 
 1 <= s.length <= 5 * 10⁴ 
 
 s 包含可打印的 ASCII 字符。 
 
 s 不包含任何开头或结尾空格。 
 
 s 里 至少 有一个词。 
 
 s 中的所有单词都用一个空格隔开。 
 

 Related Topics 双指针 字符串 👍 549 👎 0

*/

package leetcode.editor.cn;
class ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("Let's take LeetCode contest"));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        while (right <= chars.length){
            if(right == chars.length || chars[right] == ' '){
                reverse(chars,left,right - 1);
                left = ++right;
            }
            else{
                right++;
            }
        }
        return String.valueOf(chars);
    }
    public void reverse(char[] chars,int left,int right){
        while (left < right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
