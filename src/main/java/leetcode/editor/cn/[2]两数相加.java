//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9468 👎 0


package leetcode.editor.cn;
class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4)));
        ListNode result = solution.addTwoNumbers(l1,l2);
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rootNode = new ListNode(0); //首链表节点
        ListNode currentNode = rootNode;//当前链表节点
        int carry = 0; //进位值
        while (l1 != null || l2 != null){
            //如果当前节点为空则用0补齐
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            //计算当前节点值
            int sum = a + b + carry;
            //计算进位值   9+9=19 则进位值为19/10=1
            carry = sum / 10;
            //处理当前进位值 9+9=19 则当前值应该为19%10=9
            sum %= 10;

            //保存结果
            currentNode.next = new ListNode(sum);
            //移动链表指针
            currentNode = currentNode.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }

        //如果进位值还有值则在添加一个
        if(carry == 1){
            currentNode.next = new ListNode(1);
        }

        return rootNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

 class ListNode {
    //当前元素值
     int val;
     //下一个元素引用
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
