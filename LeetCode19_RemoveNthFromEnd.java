/**
 * @Author: Prince
 * @Date: 2019/9/16
 * @Descripton: PACKAGE_NAME
 * @version: 1.0
 */
/*
题目描述：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：
给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
*/
/*
题目思路：
    双指针解法：使用两个指针fast和slow，先让fast走n步，再让fast和slow同时往前走。当fast走到头时，slow即是
    倒数第n+1个节点了。令slow.next = slow.next.next;则删除了倒数第n个节点
    特殊情况：case1：链表长度小于n，则返回原链表
            case2：链表长度为n，则返回head.next;
 */
public class LeetCode19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head;
        int i;
        for(i=0;i<n;i++){
            fast = fast.next;
            if(fast==null){
                break;
            }
        }
        if(i==n-1 && fast==null) {  //链表长度为n时，删除头结点
            return head.next;
        }
        if(i<n-1 && fast==null){    //如果链表长度小于n，则返回原链表
            return  head;
        }

        ListNode slow = head;

        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}


