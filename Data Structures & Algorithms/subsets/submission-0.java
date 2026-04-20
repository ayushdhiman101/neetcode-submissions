class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsetsCalc(nums, new ArrayList<>(), 0);
        return ans;
    }
    void subsetsCalc(int[] nums, List<Integer> temp, int i) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        subsetsCalc(nums, temp, i+1);

        temp.remove(temp.size() - 1);

        subsetsCalc(nums, temp, i+1);
        return;
    }

}
