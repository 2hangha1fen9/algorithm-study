/**
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 

 

 示例 1： 
 
 
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
 

 示例 2： 

 
输入：head = [1], n = 1
输出：[]
 

 示例 3： 

 
输入：head = [1,2], n = 1
输出：[1]
 

 

 提示： 

 
 链表中结点的数目为 sz 
 1 <= sz <= 30 
 0 <= Node.val <= 100 
 1 <= n <= sz 
 

 

 进阶：你能尝试使用一趟扫描实现吗？ 

 Related Topics 链表 双指针 👍 2509 👎 0

*/

package leetcode.editor.cn;

import java.util.List;

class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeNthFromEnd(
                new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4)))),1);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode result = new ListNode();
        //预留一个元素用来遍历长度
        result.next = head;

        //遍历出链表长度
        int count = 0;
        ListNode currentNode = result;
        while (currentNode.next != null){
            currentNode = currentNode.next;
            count++;
        }

        //遍历出要删除的节点的前一个
        currentNode = result;
        for(int i = 0;i < (count - n);i++){
            currentNode = currentNode.next;
        }

        //删除元素
        // a--->b---c
        // a--->c
        currentNode.next = currentNode.next.next;

        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
