class Solution {
    private List<List<Integer>> sol = new ArrayList<>(); 
    private int n;
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> currCombo = new ArrayList<>();
        backtrack(0,currCombo,nums);
        return sol; 
    }

    public void backtrack(int first, List<Integer> curr, int[] nums){
        System.out.println(" line 12 curr ->"+Arrays.asList(curr));
        sol.add(new ArrayList(curr));
        System.out.println(" line 14 sol -> "+Arrays.asList(sol));

        for(int i = first; i< n; ++i){
            curr.add(nums[i]);
            System.out.println("number is "+Arrays.asList(curr));
            backtrack(i+1,curr, nums);
            System.out.println(" removed: -> "+curr.remove(curr.size()-1));
        }
    }
}
/*
public int backtrack(STATE curr, OTHER_ARGUMENTS...) {
    if (BASE_CASE) {
        // modify the answer
        return 0;
    }

    int ans = 0;
    for (ITERATE_OVER_INPUT) {
        // modify the current state
        ans += backtrack(curr, OTHER_ARGUMENTS...)
        // undo the modification of the current state
    }
}
*/
