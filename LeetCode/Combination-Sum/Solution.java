1class Solution {
2    public List<List<Integer>> combinationSum(int[] candidates, int target) {
3        List<List<Integer>>result=new ArrayList<>();
4        List<Integer>temp=new ArrayList<>();
5        backtrack(candidates,target,result,temp,0);
6        return result;
7    }
8    void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> temp, int start) {
9        if (target == 0) {
10            result.add(new ArrayList<>(temp));
11            return;
12        }
13
14        if (target < 0) {
15            return;
16        }
17
18        for (int i = start; i < candidates.length; i++) {
19            temp.add(candidates[i]); 
20            backtrack(candidates, target - candidates[i], result, temp, i); // explore
21            temp.remove(temp.size() - 1);
22        }
23    }
24}