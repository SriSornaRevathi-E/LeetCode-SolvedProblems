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
    public static ListNode reverseList(ListNode sh){
        ListNode curr=sh;
        ListNode prev=null;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        } 
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
         ListNode slow=head;
          ListNode fast=head;
          while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
          }
          ListNode sh= slow.next;
          slow.next=null;
          sh =reverseList(sh);
          ListNode p1=head;
          ListNode p2=sh;
          while(p2!=null){
            if(p1.val!=p2.val){
                return false;
            }
            p1=p1.next;
            p2=p2.next;
          }
          return true;
    }
}