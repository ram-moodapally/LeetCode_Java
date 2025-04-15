class Solution {
    private int[][] sol; 
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length; 
        int n = mat[0].length; 
        int[][] sol = new int[m][n];

        Queue<int[]> queue = new LinkedList<>(); 

        // Initialize the solution matrix 

        for( int i = 0; i < m; i++){
            for(int j = 0; j< n; j++){
                if(mat[i][j] == 0){
                    sol[i][j] = 0;
                    queue.offer(new int[]{i,j});
                } else{
                    sol[i][j] = Integer.MAX_VALUE; 
                }
            }
        }

        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll(); 
            int x = cell[0], y =cell[1];

            for( int[] d: dir){
                int newX = x+d[0];
                int newY = y+d[1];

                if( newX >= 0 && newX< m && newY>=0 && newY< n && sol[newX][newY] > sol[x][y] + 1){
                    sol[newX][newY] = sol[x][y]+1;
                    queue.offer(new int[]{newX,newY});
                }
            }
        }
        return sol;

    }
}
/**
psudocode 
1. Enqueu all 0's and initialize s and 1 as INF, 
2. directions for l,r,u,d
3. BFS
as we compare sol[new]>sol[curr] , we are ensuring both vist and avoid revisiting. 
4. return res;
 */
