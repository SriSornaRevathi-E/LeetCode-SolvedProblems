import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        Arrays.sort(candidates); // add this

        backtrack(candidates, target, result, temp, 0);
        return result;
    }

    void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //  skip duplicates
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // stop if greater than target
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            //  i → i+1 (important)
            backtrack(candidates, target - candidates[i], result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}