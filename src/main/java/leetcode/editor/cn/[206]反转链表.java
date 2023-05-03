/**
给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

 
 
 
 
 

 示例 1： 
 
 
输入：head = [1,2,3,4,5]
输出：[5,4,3,2,1]
 

 示例 2： 
 
 
输入：head = [1,2]
输出：[2,1]
 

 示例 3： 

 
输入：head = []
输出：[]
 

 

 提示： 

 
 链表中节点的数目范围是 [0, 5000] 
 -5000 <= Node.val <= 5000 
 

 

 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 

 Related Topics 递归 链表 👍 3123 👎 0

*/

package leetcode.editor.cn;

import java.util.LinkedList;

class ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node = new ListNode(1,new ListNode(2,new ListNode(3)));
        solution.reverseList(node);
    }
    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //栈
    public ListNode reverseList_1(ListNode head) {
        LinkedList<ListNode> nodes = new LinkedList<>();
        ListNode temp = head;
        //所有节点入栈
        while (temp != null){
            nodes.addFirst(temp);
            temp = temp.next;
        }
        //重组链表
        ListNode result = new ListNode();
        temp = result;
        while (nodes.size() > 0){
            temp.next = nodes.removeFirst();
            temp = temp.next;
        }
        temp.next = null;
        return result.next;
    }
    //双链表
    public ListNode reverseList_2(ListNode head){
        ListNode result = null;
        while (head != null){
            ListNode nextHead = head.next;
            head.next = result;
            result = head;
            head = nextHead;
        }
        return result;
    }

    //递归
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null)
            return head;
        ListNode reverse = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverse;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
