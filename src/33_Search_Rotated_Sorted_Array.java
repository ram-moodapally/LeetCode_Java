class Solution {
    public int search(int[] nums, int target) {

        // if ( nums.length == 1 && nums[0] == target){
        //     return 0; 
        // }
        int right = nums.length -1 ; 
        int left = 0; 

        while(right >= left){
            int mid = left+(right - left)/2; 

            if(nums[mid] == target){
                return mid; 
            }
            else if (nums[mid] >= nums[left]){
                if(target>= nums[left] && target< nums[mid] ){
                    right  = mid -1 ;
                }else{
                    left = mid+1; 
                }
            } else{
                if(target> nums[mid] && target <= nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid -1;
                }
            }

        }
        return -1; 
    }
}

/*
return the index of the target 

if the target element is less thna the 0th element then its on the right 

else its on the lfet 

*/ 
