/**
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 

 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 

 

 示例 1: 

 
输入: s = "anagram", t = "nagaram"
输出: true
 

 示例 2: 

 
输入: s = "rat", t = "car"
输出: false 

 

 提示: 

 
 1 <= s.length, t.length <= 5 * 10⁴ 
 s 和 t 仅包含小写字母 
 

 

 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 

 Related Topics 哈希表 字符串 排序 👍 768 👎 0

*/

package leetcode.editor.cn;

import java.util.Arrays;

class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isAnagram("nl","cx"));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //排序后比较
    public boolean isAnagram_1(String s, String t) {
        //长度不一致直接返回false
        if(s.length() != t.length()){
            return false;
        }
        //排序后比较每一位
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);

        for(int i = 0;i < ss.length;i++){
            if(ss[i] != tt[i]){
                return false;
            }
        }
        return true;
    }

    //使用Hash表
    public boolean isAnagram_2(String s, String t){
        if(s.length() != t.length()){
            return false;
        }
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for(int i = 0;i < ss.length;i++){
            hash1[ss[i] - 'a']++;
            hash2[tt[i] - 'a']++;
        }

        for(int i = 0;i < 26;i++){
            if(hash1[i] != hash2[i]){
                return false;
            }
        }
        return true;
    }

    //一次遍历
    //使用一个变量count记录新出现字符的个数，然后同时遍历两个数组，如果出现了一个新的字符，count就加1，如果消失了一个字符，count就减1，最后判断count是否等于0即可。
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] hash = new int[26];
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int count = 0;
        for(int i = 0;i < ss.length;i++){
            if(++hash[ss[i] - 'a'] == 1){
                count++;
            }
            if(--hash[tt[i] - 'a'] == 0){
                count--;
            }
        }
        return count == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
