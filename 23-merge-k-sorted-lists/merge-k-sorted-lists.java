class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Min Heap
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);
        // Add first node of each list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!pq.isEmpty()) {
            // Get smallest node
            ListNode node = pq.poll();
            // Add to result
            current.next = node;
            current = current.next;
            // Add next node
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
}