/**
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 

 有效字符串需满足： 

 
 左括号必须用相同类型的右括号闭合。 
 左括号必须以正确的顺序闭合。 
 每个右括号都有一个对应的相同类型的左括号。 
 

 

 示例 1： 

 
输入：s = "()"
输出：true
 

 示例 2： 

 
输入：s = "()[]{}"
输出：true
 

 示例 3： 

 
输入：s = "(]"
输出：false
 

 

 提示： 

 
 1 <= s.length <= 10⁴ 
 s 仅由括号 '()[]{}' 组成 
 

 Related Topics 栈 字符串 👍 3932 👎 0

*/

package leetcode.editor.cn;

import java.util.Stack;

class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("((())))"));
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        //遍历所有的元素
        for(char c : chars){
            if(c == '('){
                stack.push(')');
            }
            else if(c == '['){
                stack.push(']');
            }
            else if(c == '{'){
                stack.push('}');
            }
            else if(stack.isEmpty() || stack.pop() != c){
                //否则就只能是右括号。
                //1，如果栈为空，说明括号无法匹配。
                //2，如果栈不为空，栈顶元素就要出栈，和这个右括号比较。
                //如果栈顶元素不等于这个右括号，说明无法匹配，
                //直接返回false。
                return false;
            }
        }
        //最后如果栈为空，说明完全匹配，是有效的括号。
        //否则不完全匹配，就不是有效的括号
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
