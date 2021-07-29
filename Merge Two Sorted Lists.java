// link - 
//recursive approach.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}

//iterative approach


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode newhead = null;
        ListNode newtail = null;
        
        if(l1.val > l2.val) {
            newhead = l2;
            newtail = l2;
            l2 = l2.next; 
        }
        else { 
            newhead = l1;
            newtail = l1;
            l1 = l1.next;
        }
        
        while(l1!=null && l2!=null) {
            if(l1.val > l2.val) {
                newtail.next = l2;
                newtail =  l2;
                l2 = l2.next;
            }
            else {
                newtail.next = l1;
                newtail = l1;
                l1 = l1.next;
            }
        }
        if(l1!=null) {
            newtail.next = l1;
            l1 = l1.next;
        }
        else {
            newtail.next = l2;
            l2 = l2.next;
        }
        return newhead;
    }
}
