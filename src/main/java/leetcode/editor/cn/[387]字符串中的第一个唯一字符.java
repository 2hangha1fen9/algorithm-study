/**
给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。 

 

 示例 1： 

 
输入: s = "leetcode"
输出: 0
 

 示例 2: 

 
输入: s = "loveleetcode"
输出: 2
 

 示例 3: 

 
输入: s = "aabb"
输出: -1
 

 

 提示: 

 
 1 <= s.length <= 10⁵ 
 s 只包含小写字母 
 

 Related Topics 队列 哈希表 字符串 计数 👍 666 👎 0

*/

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class FirstUniqueCharacterInAString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("loveleetcode"));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 哈希表记数
    public int firstUniqChar_1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length;i++){
            map.put(c[i],map.getOrDefault(c[i],0) + 1);
        }
        for(int i = 0;i < c.length;i++){
            if(map.get(c[i]) == 1){
                return i;
            }
        }
        return -1;
    }
    //自定义哈希表
    public int firstUniqChar_2(String s){
        int[] hash = new int[26];
        char[] c = s.toCharArray();
        for(int i = 0;i < c.length;i++){
            hash[c[i] - 'a']++;
        }
        for(int i = 0;i < c.length;i++){
            if(hash[c[i] - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
    //使用API
    public int firstUniqChar(String s){
        for(int i = 0;i < s.length();i++){
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
