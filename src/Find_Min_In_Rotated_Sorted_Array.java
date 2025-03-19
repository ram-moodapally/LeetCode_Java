class Solution {
    public int findMin(int[] nums) {

        if (nums.length ==1 ){
            return nums[0];
        }

        int left = 0, right = nums.length -1; 

        if(nums[right] > nums[ left]){
            return nums[left];
        }

        while( right >= left){
            int mid = left + (right - left )/ 2; 

            if(nums[mid] > nums[mid+1]){
                return nums[mid+ 1];
            }
            if (nums[mid - 1]> nums[mid]){
                return nums[mid];
            }

            if( nums[mid] > nums[0]){
                left = mid + 1; 
            }
            else{
                right = mid -1; 
            }
        }
        return Integer.MAX_VALUE;
    }
}

/*

inflection point 
which direction of the rotation 
O(log n)

/Binary search 

mid = (right -left)/2 + 1

if nums()
if left > right then its rotated and the min number is on the right, 

we can say find the pivint point. 
monotonic arrary? 

what are the edge conditions: 

in general 

if (arr[mid] == target) {
            // do something
            return mid;
        }

*/
