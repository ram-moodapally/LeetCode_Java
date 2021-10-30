//problem URL: https://leetcode.com/problems/two-sum/
//      @author:ram

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int order[] = new int[2];
        int aux[] =  new int[nums.length];
        for (int i=0; i< nums.length; i++){
            aux[i]=nums[i];
        }
        /*for (int i =0; i < nums.length ; i++){
            for (int j = i+1; j< nums.length; j++){
                if (nums[j]+ nums[i] == target){
                    order[0]= i;
                    order[1] = j;
                    break;
                }
            }
        }
        return order;
        */
        Arrays.sort(aux);
        for (int i=0; i< aux.length; i++){
            System.out.print(", "+aux[i]);
        }
        System.out.println("the original array is");
        for (int i=0; i< aux.length; i++){
            System.out.print(", "+nums[i]);
        }
        //challenge is to send the index of original array.

        //
        int reqValue2 = -999999; //value from the sorted array.
        int reqValue1 = -999999;
        for (int i =0; i< nums.length; i++){
            int aa = aux[i];
            //order[i] = nums[i];
            int req = target - aux[i];
            //System.out.println(aux[i]+" for sum -8,required remaining is "+req);

            int reqKey = Arrays.binarySearch(aux,req); //returns the key of required value, if not where
            if(reqKey>=0){
                reqValue2 = aux[reqKey];
                reqValue1 = aux[i];
                if(reqValue2<0  && reqValue1<0){
                    System.out.println("both the values are negative");
                    int temp = reqValue2;
                    reqValue2=reqValue1;
                    reqValue1 = temp;

                }

                break;
            }

        }


        int j=0;
        for (int i =0; i<nums.length; i++){
           //below is logic was output of 1hr thinking - solved when thinking put on paper.
            if( nums[i] == reqValue1 || nums[i] == reqValue2){
                order[j]=i;
                j++;
                if(j==2) break;
            }


        }
        return order;

    }
}
