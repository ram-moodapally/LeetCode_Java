public class ContainsDuplicate_217_easy {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        //int i =0;
        boolean hasDuplicate = false;
        for (int i=0; i< nums.length -1; i++){
            if(nums[i] == nums[i+1]){
                hasDuplicate=true;
                break;
            }
        }
        if (hasDuplicate) return true;
        else return false;


    }
}
