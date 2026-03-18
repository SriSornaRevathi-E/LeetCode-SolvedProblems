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
17    public List<List<Integer>> levelOrderBottom(TreeNode root) {
18        List<List<Integer>> res = new ArrayList<>();
19        Queue<TreeNode> q = new LinkedList<>();
20
21        if (root == null) {
22            return res;
23        }
24
25        q.add(root);
26
27        while (!q.isEmpty()) {
28            int size = q.size();
29            List<Integer> level = new ArrayList<>();
30
31            for (int i = 0; i < size; i++) {
32                TreeNode node = q.poll();
33                level.add(node.val);
34
35                if (node.left != null) {
36                    q.add(node.left);
37                }
38                if (node.right != null) {
39                    q.add(node.right);
40                }
41            }
42
43            res.add(0,level);
44        }
45
46        return res;
47    }
48}