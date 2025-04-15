class Solution {
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length; 
        int col = rooms[0].length; 

        Queue<int[]> queue = new LinkedList<>(); 
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};


        for(int i = 0; i< row; i++){
            for( int j =0; j< col; j++){
                if( rooms[i][j] == 0 ){
                    queue.add(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){

            int[] curr = queue.poll(); 
            for(int[] d: dir){
                int newX = curr[0]+d[0];
                int newY = curr[1]+d[1];

                if( newX<0 || newX>= row || newY < 0 || newY>= col || rooms[newX][newY] != Integer.MAX_VALUE){
                    continue; 
                }
                rooms[newX][newY] = rooms[curr[0]][curr[1]] + 1;
                queue.add(new int[]{newX, newY});
            }
        }
    }
}
/**
BFS - void so use the same matrix 
multi source BFS - > so add all gates to queue 
tirgger while(Q is not empty){
    poll 
    new x and y 
    boundry check and check rooms[new xy] != INF
        continue
    rooms[newX][newY] = rooms[curr[0]][curr[1]] + 1;
    queue.add(new int[]{newX, newY});
}
 */
