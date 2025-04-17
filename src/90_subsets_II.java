class Solution {
    private List<List<Integer>> sol = new ArrayList<>(); 
    private int n; 
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length; 
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>(); 
        backtrack(0,curr,nums);
        return sol; 
    }

    public void backtrack(int first, List<Integer> curr, int[] nums){
        sol.add(new ArrayList(curr));
        
        for(int i = first; i< n; ++i){
            if(i> first && nums[i] == nums[i-1]) continue; 
                curr.add(nums[i]);
                backtrack(i+1, curr, nums);
                curr.remove(curr.size()-1);
        }
    }
}

/**
same like subset, it shouldn't contain duplicate. 

duplicates, - always think of sorting and then then skiping the next elemnt 
 */
