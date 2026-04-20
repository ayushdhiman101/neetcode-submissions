class Solution {
   
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsCalc(nums, new ArrayList<>(), 0, ans);
        return ans;
    }
    void subsetsCalc(int[] nums, List<Integer> temp, int i, List<List<Integer>> ans) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subsetsCalc(nums, temp, i+1, ans);

        temp.remove(temp.size() - 1);

        subsetsCalc(nums, temp, i+1, ans);
        return;
    }

}
