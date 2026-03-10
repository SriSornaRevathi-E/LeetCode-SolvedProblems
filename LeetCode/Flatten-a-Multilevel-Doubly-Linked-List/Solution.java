1class Solution {
2    public Node flatten(Node head) {
3        if (head == null) {
4            return head;
5        }
6        Node cur = head;
7        while (cur != null) {
8            if (cur.child != null) {
9                Node next = cur.next;
10                cur.next = flatten(cur.child);
11                cur.next.prev = cur;
12                cur.child = null;
13                while (cur.next != null) {
14                    cur = cur.next;
15                }
16                if (next != null) {
17                    cur.next = next;
18                    next.prev = cur;
19                }
20            }
21            cur = cur.next;
22        }
23        return head;
24    }
25}