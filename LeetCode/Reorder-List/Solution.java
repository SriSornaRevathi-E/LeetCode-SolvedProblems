1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public void reorderList(ListNode head) {
13        if(head==null){
14            return;
15        }
16        ListNode slow=head;
17        ListNode fast=head;
18        while(fast!=null && fast.next!=null){
19            slow=slow.next;
20            fast=fast.next.next;
21        }
22        ListNode prev=null;
23        while(slow!=null){
24            ListNode next=slow.next;
25            slow.next=prev;
26            prev=slow;
27            slow=next;
28        }
29        ListNode first=head;
30        ListNode second=prev;
31        while(second.next!=null){
32            ListNode temp1=first.next;
33            ListNode temp2=second.next;
34            first.next=second;
35            second.next=temp1;
36            first=temp1;
37            second=temp2;
38        }
39        
40    }
41}