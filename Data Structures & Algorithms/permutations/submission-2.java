class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return ans;
        permute2(nums, new ArrayList<>(), 0);
        return ans;
        
    }
    public void permute2(int[] nums, List<Integer> temp, int idx) {

        if(idx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i: nums) list.add(i);
                ans.add(list);
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            permute2(nums, temp, idx + 1);
            swap(nums, i, idx);
        }
        return;
    }
    public void swap(int[] nums, int idx, int i) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
 }
