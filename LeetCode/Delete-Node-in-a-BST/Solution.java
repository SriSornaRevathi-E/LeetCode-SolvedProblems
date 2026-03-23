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
17    public TreeNode deleteNode(TreeNode root, int key) {
18        if(root==null) return null;
19        if(key<root.val){
20            root.left=deleteNode(root.left,key);
21        }
22        else if(key>root.val){
23            root.right=deleteNode(root.right,key);
24        }
25        else{
26            if(root.left==null&&root.right==null){
27                return null;
28            }
29            else if(root.left==null){
30                return root.right;
31            }
32            else if(root.right==null){
33                return root.left;
34            }
35            else{
36                TreeNode temp=findMin(root.right);
37                root.val=temp.val;
38                root.right=deleteNode(root.right,temp.val);
39            }
40        }
41        return root;
42    }
43    public TreeNode findMin(TreeNode root) {
44        while (root.left != null) {
45            root = root.left;
46        }
47        return root;
48    }
49}