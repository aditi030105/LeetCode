class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> path, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (remain < 0) return;

        for (int i = start; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > remain) break;
            path.add(num);
            backtrack(candidates, remain - num, i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
