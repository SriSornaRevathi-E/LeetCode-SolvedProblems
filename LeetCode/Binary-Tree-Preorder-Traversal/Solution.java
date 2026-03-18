1class Solution {
2    List<Integer> res = new ArrayList<>();
3
4    public List<Integer> preorderTraversal(TreeNode root) {
5        preorder(root);
6        return res;
7    }
8
9    void preorder(TreeNode root) {
10        if (root == null)
11            return;
12
13        res.add(root.val);        // Root
14        preorder(root.left);      // Left
15        preorder(root.right);     // Right
16    }
17}
18