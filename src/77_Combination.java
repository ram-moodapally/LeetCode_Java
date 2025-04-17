class Solution {

    List<List<Integer>> sol = new ArrayList<>(); 
    public List<List<Integer>> combine(int n, int k) {
        backtracking(1,new ArrayList<>(), n,k);
        return sol; 
    }

    public void backtracking(int first, List<Integer> curr, int n, int k){

        // base condition in this problem the tree size should be less than 0 
        if( curr.size() == k){
            sol.add(new ArrayList(curr)); // making a deep copy
            return; 
        }

        //List<Integer> curr = new ArrayList<>(); this is not needed ,as your are passing
        // at call using the variable in the method 

        // explore all the numbers from first to n
        for(int i = first; i<=n; i++){

            // modify the current state 
            curr.add(i);   // choosen
            // call the back tracking function 
            backtracking( i+1, curr, n, k);
            // remove what was just added 
            curr.remove(curr.size() -1);
        }
    }
}
/**

1,2,3,4

You're building combinations of size k from numbers 1 to n.
Backtracking works by:
Picking a number (curr.add(i)),
Exploring all options that follow it (backtracking(i+1, ...)),
Then undoing the choice (curr.remove(...)).

 */
