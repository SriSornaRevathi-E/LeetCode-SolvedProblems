1class Solution {
2    public void backtrack(TreeNode root, List<Integer> res, int level) {
3        if (root == null) {
4            return;
5        }
6        if (res.size() == level) {
7            res.add(root.val);
8        }
9        backtrack(root.right, res, level + 1);
10        backtrack(root.left, res, level + 1);
11    }
12
13    public List<Integer> rightSideView(TreeNode root) {
14        List<Integer> res = new ArrayList<>();
15        backtrack(root, res, 0);
16        return res;
17    }
18}