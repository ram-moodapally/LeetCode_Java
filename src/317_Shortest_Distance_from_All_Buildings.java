class Solution {
    public int shortestDistance(int[][] grid) {
        int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        int row = grid.length; 
        int col = grid[0].length; 

        int[][] distance = new int[row][col];

        int landValue = 0, minDis = Integer.MAX_VALUE; 

        for(int i =0; i< row; i++){
            for(int j = 0; j< col; j++){
                if(grid[i][j] == 1){
                    // we need to trigger BFS from here 
                    Queue<int[]>  queue = new LinkedList<>(); 
                    // minDis = Integer.MIN_VALUE; 
                    queue.offer(new int[]{i,j});
                    int step = 0; 
                    while(!queue.isEmpty()){
                        // increment step 
                        step++;
                        for(int level = queue.size(); level>0; --level){
                            int[] curr = queue.poll();

                            for(int[] d: dirs){
                                int newX = curr[0]+d[0];
                                int newY = curr[1]+d[1];

                                if(newX >=0 && newX<row && newY>=0 && newY <col && grid[newX][newY] == landValue){
                                    grid[newX][newY]--;
                                    distance[newX][newY] += step;
                                    queue.offer(new int[]{newX, newY});
                                    
                                }
                            }
                        }
                    }
                    landValue--;
                }
            }
        }

        for( int i = 0; i< row; i++){
            for(int j = 0; j< col; j++){
                if( grid[i][j] == landValue){
                minDis = Math.min(minDis, distance[i][j]);}
            }
        }

        if(minDis == Integer.MAX_VALUE){
            return -1;
        }
        return minDis; 
    }
}

/**
put all the 1 in the priority queue. 
for reach priority queue -> 

-> use the same grid mark visited or not 
-> use the land value as check for the next parameter. 
-> new matrix to get the solution 

 */
