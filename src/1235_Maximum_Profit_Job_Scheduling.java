class Solution {
    private int sol = -1; 
    private int[] memo = new int[50001];
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        List<List<Integer>> job = new ArrayList<>(); 
        if ( profit.length == 0){
            return 0; 
        }
        int n = profit.length; 
        Arrays.fill(memo, -1);
        for(int i =0; i< n; i++){
            List<Integer> ithjob = new ArrayList<>(); 
            ithjob.add(startTime[i]);
            ithjob.add(endTime[i]);
            ithjob.add(profit[i]);
            job.add(ithjob);
        }
        job.sort((job1, job2) -> job1.get(0) - job2.get(0));

        for(int i = 0; i< n; i++){
            startTime[i] = job.get(i).get(0);
        }

 
        return findMaxProfit( job, startTime, n, 0); 

    }
    private int findMaxProfit(List<List<Integer>> jobs, int[] startTime, int n, int position ){
        // if we have already itereated all the position 
        if( position == n){ // this is essential for the handling edge conditon for the binary search 
            return 0; 
        }
        if( memo[position] != -1){
            return memo[position];
        }
        // we need to find the next con conflicting job index 
        int j = findNextJob(startTime, jobs.get(position).get(1));
        int maxProfit = Math.max(
            // skip the current job 
            findMaxProfit(jobs,startTime,n, position+1),
            // take the current job and look for the next profit 
            jobs.get(position).get(2) + findMaxProfit(jobs, startTime, n, j)
            );
        return memo[position] = maxProfit; 


        // return maxProfit; 
    }
    // find the starttime >= lastjobEndinTime
    private int findNextJob(int[] startTime, int lastJobEndingTime ){
        int start = 0, end  = startTime.length-1, nextIndex = startTime.length; 

        while(start <= end){
            int mid = (start+end)/2; 
            if( startTime[mid] >= lastJobEndingTime){
                end = mid -1; 
                nextIndex  = mid; 
            }
            else{
                start = mid+1;
            }
        }
        return nextIndex;  
    }
}
/**
psudo code:

1. Create a list of jobs as tuples: (startTime[i], endTime[i], profit[i])

2. Sort the jobs based on **start time** (can also sort by end time depending on your implementation)

3. Initialize memoization array `dp` of size n, where `dp[i]` stores max profit starting from job[i]

4. Define a recursive function:
   maxProfitFrom(index):
       if index >= n:
           return 0

       if dp[index] != -1:
           return dp[index]

       // Option 1: Skip current job
       profit1 = maxProfitFrom(index + 1)

       // Option 2: Take current job
       nextIndex = binarySearchNextNonOverlappingJob(index)
       profit2 = jobs[index].profit + maxProfitFrom(nextIndex)

       dp[index] = max(profit1, profit2)
       return dp[index]

5. Binary search logic:
   - Find the earliest job where startTime >= jobs[current].endTime
   - This ensures no overlap

6. Return maxProfitFrom(0)

1. first try to sort the job wrt to start time. Why ( we will get an immediate idea if we have to choose the next job or not based on our current job last time - check for the non overlapping condition)

now during the sub problem - should I keep track of the end time of each job , not needed actually, 
how do we mi 



why dynamic programming? 

There are two key characteristics of this problem that we should take note of at this time. First, a job cannot be scheduled if a conflicting job has already been scheduled. In other words, each decision we make is affected by the previous decisions we have made. Second, the problem asks us to maximize the profit by scheduling non-conflicting jobs. These are two common characteristics of dynamic programming problems, and as such we will approach this problem using dynamic programming.

example why greedy is not an optimial solution? give example  

what could be the sub problem? 



 */
