1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public List<List<Integer>> verticalTraversal(TreeNode root) {
18        List<int[]> list = new ArrayList<>();
19        Queue<Object[]> q = new LinkedList<>();
20        q.offer(new Object[]{root, 0, 0});
21        while (!q.isEmpty()) {
22            Object[] arr = q.poll();
23            TreeNode node = (TreeNode) arr[0];
24            int row = (int) arr[1];
25            int col = (int) arr[2];
26            list.add(new int[]{col, row, node.val});
27            if (node.left != null) {
28                q.offer(new Object[]{node.left, row + 1, col - 1});
29            }
30            if (node.right != null) {
31                q.offer(new Object[]{node.right, row + 1, col + 1});
32            }
33        }
34        Collections.sort(list, (a, b) -> {
35            if (a[0] != b[0]) return a[0] - b[0];
36            if (a[1] != b[1]) return a[1] - b[1];
37            return a[2] - b[2];
38        });
39        List<List<Integer>> result = new ArrayList<>();
40        int prevCol = Integer.MIN_VALUE;
41        for (int[] node : list) {
42            if (node[0] != prevCol) {
43                result.add(new ArrayList<>());
44                prevCol = node[0];
45            }
46            result.get(result.size() - 1).add(node[2]);
47        }
48        return result;
49    }
50}