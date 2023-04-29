/**
给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果
 needle 不是 haystack 的一部分，则返回 -1 。 

 

 示例 1： 

 
输入：haystack = "sadbutsad", needle = "sad"
输出：0
解释："sad" 在下标 0 和 6 处匹配。
第一个匹配项的下标是 0 ，所以返回 0 。
 

 示例 2： 

 
输入：haystack = "leetcode", needle = "leeto"
输出：-1
解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 

 

 提示： 

 
 1 <= haystack.length, needle.length <= 10⁴ 
 haystack 和 needle 仅由小写英文字符组成 
 

 Related Topics 双指针 字符串 字符串匹配 👍 1847 👎 0

*/

package leetcode.editor.cn;
class FindTheIndexOfTheFirstOccurrenceInAString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("aabacabfdhfdsabacabablkfsdfasdhasd","abacabab"));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //使用API
    public int strStr_1(String haystack, String needle){
        return haystack.indexOf(needle);
    }
    //逐字匹配
    public int strStr_2(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int a = 0;
        int b = 0;
        while (a < h.length && b < n.length){
            if(h[a] == n[b]){
                a++;
                b++;
            }else{
                //如果不匹配，就回退，从第一次匹配的下一个开始，
                a = a - b + 1;
                b = 0;
            }
            if(b == n.length){
                return a - b;
            }
        }
        return -1;
    }
    //KMP
    public int strStr(String haystack, String needle){
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        int[] next = new int[n.length]; //最长公共前后缀表

        //构建next数组
        int a = 0; //当前最长公共前后缀长度，遇到特殊情况会回溯
        int b = 1; //线性指针
        while (b < next.length){
            if(n[a] == n[b]){ //两个数相等，两个指针同时向前移动，且当前最长前后缀+1
                a++;
                next[b] = a;
                b++;
            }
            else if(a == 0){ //如果开头就不匹配则无法构成公共前后缀，则为0
                next[b] = 0;
                b++;
            }
            else{ //遇到下一个位置不匹配，则回溯到a指针前一位的前后缀长度，后续继续匹配
                a = next[a - 1];
            }
        }

        //利用next加速匹配
        a = b = 0;
        while (a < h.length){
            if(h[a] == n[b]){ //相等两个指针同时前进
                a++;
                b++;
            }
            else if(b != 0){ //两个数不想等，根据最长公共前后缀表进行回溯
                b = next[b - 1];
            }
            else{ //开头就不匹配，则直接进行下一位匹配
                a++;
            }
            if(b == n.length){
                return a - b;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
