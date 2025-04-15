class Solution {
    private static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private int m,n; 
    public int longestIncreasingPath(int[][] matrix) {

        m = matrix.length; 
        n = matrix[0].length; 

        int[][] cache = new int[m][n];
        int ans = 0; 

        for(int i = 0; i< m; i++){
            for(int j = 0; j<n; j++){
                ans = Math.max(ans,dfs(matrix, i,j,cache));
            }
        }
        return ans; 

        
    }


    private int dfs(int[][] matrix, int i, int j, int[][] cache){
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        for(int[] d: dir){
            int x = i+d[0], y= j+d[1];
            if(x>=0 && x<m && y>=0 && y<n && matrix[x][y] > matrix[i][j]){
                cache[i][j] = Math.max(cache[i][j], dfs(matrix,x,y,cache));
            }
        }
        return cache[i][j]+=1;
    }
}
/**
use DFS
create a helper function DFS( and sent cache mtraix ){
traverse the main function  and call dfs on each:
main ->     ans = Math.max(ans,dfs(matrix, i,j,cache));

inside dfs(i, j){
    check and return cache first 
    iterate the direction 
        boundry conditions 
        x = i+d. y => j+d
    on new index->      cache[i][j] = Math.max(cache[i][j], dfs(matrix,x,y,cache));   

    finally return cache[i][j];
}
}
 */
