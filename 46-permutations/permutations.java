class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(nums, res, temp);
        return res;
    }
    public void backtrack(int[] nums, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backtrack(nums, res, temp);
            temp.remove(temp.size() - 1);
        }
    }
}