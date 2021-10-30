//problem URL: https://leetcode.com/problems/merge-sorted-array/
//  @author: ram




class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m== 1 && n==0 ) // trival cases
            return;
        if(m==0 && n==1){ // trival cases;
            nums1[0]= nums2[0];
            return;
        }
        /*if(nums1[m-1] < nums2[0]){ // if smallest of the num2 is larger than largest of num1 - copy as it is.
            System.out.println("Entered this loop");
            for (int i=0; i<n;i++){
                nums1[m]= nums2[i];
                m++;

            }
            return;
        }*/
        {
            // now comes the action part (ill implement merge sort)
            int[] num1Temp = new int[m];
            for (int a =0;a< m; a++){
                num1Temp[a]= nums1[a];
            }
            int i=0,j =0;
            int k=0;
            while (i< m && j<n){
                if(num1Temp[i]<= nums2[j]){
                    nums1[k] = num1Temp[i];
                    i++;
                }
                else{
                    nums1[k]= nums2[j];
                    j++;
                }
                k++;

            }
            //copy the remaining elements
            while(i<m){
                nums1[k]= num1Temp[i];
                i++;
                k++;
            }
            while(j<n){
                nums1[k] = nums2[j];
                j++;
                k++;
            }
            return;
            // nums1 = numsFinal;
            /*for (int r=0; r< nums1.length; r++){
                System.out.print(","+nums1[r]);

            }*/
            //return nums1;

        }
    }
}
