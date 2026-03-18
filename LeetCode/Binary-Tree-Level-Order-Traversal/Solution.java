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
17    public List<List<Integer>> levelOrder(TreeNode root) {
18        List<List<Integer>> res=new ArrayList<>();
19        if(root==null){
20            return res;
21        }
22        Queue<TreeNode> q = new LinkedList<>(); 
23        q.offer(root); 
24
25        while(!q.isEmpty()){
26            int size = q.size();  
27            List<Integer> level = new ArrayList<>();
28            for (int i = 0; i < size; i++) {
29                TreeNode node = q.poll();
30                level.add(node.val);
31                if (node.left != null) q.offer(node.left);
32                if (node.right != null) q.offer(node.right);
33            }
34            res.add(level);
35        }
36        return res;
37    }
38    
39}