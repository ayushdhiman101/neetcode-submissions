class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return ans;

        Arrays.sort(candidates); // 🔥 already added (good)
        combinationSum2(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void combinationSum2(int[] candidates, int target, List<Integer> list, int idx) {

        // 🔥 CHANGE 1: check target first
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // 🔥 CHANGE 2: stop conditions AFTER target check
        if (target < 0 || idx == candidates.length) return;

        // 🔥 CHANGE 3: SKIP DUPLICATES (for exclude case)
        int nextIdx = idx + 1;
        while (nextIdx < candidates.length && candidates[nextIdx] == candidates[idx]) {
            nextIdx++;
        }

        // INCLUDE current element
        list.add(candidates[idx]);
        combinationSum2(candidates, target - candidates[idx], list, idx + 1);
        list.remove(list.size() - 1); // 🔥 fixed remove

        // EXCLUDE current element (skip duplicates)
        combinationSum2(candidates, target, list, nextIdx);
    }
}