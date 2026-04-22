class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        combinationSum3(nums, target, 0,  new ArrayList<Integer>());
        return ans;
    }
     public void combinationSum3(int[] nums, int target, int idx,  List<Integer> list) {
        if(0 == target) {
            List<Integer> temp = new ArrayList<>();
            for(int i: list) temp.add(i);
            if(!ans.contains(temp))
            ans.add(temp);
            return;
        }
        if(0 > target || idx == nums.length) {
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);  // ✅ FIXED
            combinationSum3(nums, target - nums[i], i + 1, list); // ✅ FIXED
            list.remove(list.size() - 1);
        }
        
    }   

}
