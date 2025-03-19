class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustArray = new int[n+1];

        for(int[] t: trust){
            trustArray[t[0]]--;
            trustArray[t[1]]++;
        }

        for(int i = 1; i<= n; i++){
            if(trustArray[i] == n-1){
                return i;
            }
        }
        return -1; 
    }
}
