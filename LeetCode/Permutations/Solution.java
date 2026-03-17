1class Solution {
2    public List<List<Integer>> permute(int[] nums) {
3        List<List<Integer>> res = new ArrayList<>();
4        List<Integer> temp = new ArrayList<>();
5        backtrack(nums, res, temp);
6        return res;
7    }
8    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp) {
9        if (temp.size() == nums.length) {
10            res.add(new ArrayList<>(temp));
11            return;
12        }
13        for (int i = 0; i < nums.length; i++) {
14            if (temp.contains(nums[i])) {
15                continue;
16            }
17            temp.add(nums[i]);
18            backtrack(nums, res, temp);
19            temp.remove(temp.size() - 1);
20        }
21    }
22}