1class Solution {
2    public ListNode mergeKLists(ListNode[] lists) {
3        // Min Heap
4        PriorityQueue<ListNode> pq =
5            new PriorityQueue<>((a, b) -> a.val - b.val);
6        // Add first node of each list
7        for (ListNode node : lists) {
8            if (node != null) {
9                pq.add(node);
10            }
11        }
12        ListNode dummy = new ListNode(0);
13        ListNode current = dummy;
14        while (!pq.isEmpty()) {
15            // Get smallest node
16            ListNode node = pq.poll();
17            // Add to result
18            current.next = node;
19            current = current.next;
20            // Add next node
21            if (node.next != null) {
22                pq.add(node.next);
23            }
24        }
25        return dummy.next;
26    }
27}