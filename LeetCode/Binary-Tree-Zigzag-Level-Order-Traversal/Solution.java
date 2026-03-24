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
17    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
18     List<List<Integer>> result=new ArrayList<>();
19     if(root==null){
20        return result;
21     }
22     Queue<TreeNode> queue=new LinkedList<>();
23     queue.offer(root);
24     boolean leftToright=true;
25     while(!queue.isEmpty()){
26        int size=queue.size();
27        LinkedList<Integer> lev=new LinkedList<>();
28        for(int i=0;i<size;i++){
29            TreeNode node=queue.poll();
30            if(leftToright){
31                lev.addLast(node.val);
32            }else{
33                lev.addFirst(node.val);
34            }
35            if(node.left!=null)queue.offer(node.left);
36            if(node.right!=null)queue.offer(node.right);
37        }
38        result.add(lev);
39        leftToright = !leftToright;
40
41     }
42     return result;
43       
44    }
45}