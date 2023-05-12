//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1566 👎 0


package leetcode.editor.cn;

import java.util.Optional;

class MinStacks{
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }
    
static
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    class Node{
        int val;
        int minVal;
        Node next;
        Node(){};
        Node(int val){
            this.val = val;
        }
        Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
        Node(int val,int minVal,Node next){
            this.val = val;
            this.minVal = minVal;
            this.next = next;
        }
    }
    private Node head;

    public MinStack() {
    }
    
    public void push(int val) {
        if(head == null){
            head = new Node(val,val,head); //待插入的节点
        }
        else{
            head = new Node(val,Math.min(head.minVal,val),head); //待插入的节点
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        int min = Integer.MAX_VALUE;
        Node cur = head;
        while (cur != null){
            if(cur.val < min){
                min = cur.val;
            }
            cur = cur.next;
        }
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}