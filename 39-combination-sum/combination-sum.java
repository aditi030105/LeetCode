import java.util.AbstractList;

class Solution {
    public static HashSet<List<Integer>> set = new HashSet<>();

    private static void combinationSum(
        int[] candidates,
        int index,
        List<Integer> list,
        List<List<Integer>> ans,
        int target) {

        if (target < 0 || candidates.length == index) {
            return;
        }

        if (target == 0) {
            System.out.println(list);
            if (!set.contains(list)) {
                ans.add(new ArrayList<>(list));
                set.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(candidates[index]);

        combinationSum(candidates, index + 1, list, ans, target - candidates[index]);
        combinationSum(candidates, index, list, ans, target - candidates[index]);
        list.remove(list.size() - 1);
        combinationSum(candidates, index + 1, list, ans, target);
        return;
    }

    private List<List<Integer>> getResults(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        set.clear();
        combinationSum(candidates, 0, list, ans, target);
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new AbstractList<List<Integer>>() {
            List<List<Integer>> ans;

            @Override
            public int size() {
                if(ans == null) {
                    ans = getResults(candidates, target);
                }
                return ans.size();
            }

            @Override
            public List<Integer> get(int index) {
                if(ans == null) {
                    ans = getResults(candidates, target);
                }
                return ans.get(index);
            }
        };
    }
}