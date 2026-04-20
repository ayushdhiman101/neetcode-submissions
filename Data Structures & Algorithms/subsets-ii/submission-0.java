class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup2(nums, new ArrayList<>(), 0);
        return ans;
    }

    public void subsetsWithDup2(int[] nums, ArrayList<Integer> temp, int i) {
        if(i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
         
        subsetsWithDup2(nums, temp, i + 1);
        temp.removeLast();

        int idx = i + 1;
        while(idx < nums.length && nums[idx] == nums[idx-1]) 
            idx++;
        subsetsWithDup2(nums, temp, idx);


    }
}
