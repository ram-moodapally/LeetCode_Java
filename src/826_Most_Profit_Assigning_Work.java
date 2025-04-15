class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length; 
        int[][] jobs= new int[n][2];
        for(int i = 0; i< n; i++){
            jobs[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(jobs,(a,b) -> b[1]-a[1] ); // Learn this decending by profit
        Arrays.sort(worker);
        int totalProfit = 0; 
        for(int k: worker){ 
            for(int[] job: jobs){
                if(k>=job[0]){
                    totalProfit+=job[1];
                    break;
                }
            }
        }
        return totalProfit;
    }
}
/**
pair jobs [ difficulty], profit[i];
sort jobs ( in the decending profit) - so that first we can select the max profi (greedy)

iterate workers 
->  iterate over sorted jobs
    -> assigned first worker>= difficut
        add to profit and break

return total profit 
 */
