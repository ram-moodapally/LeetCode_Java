/* URLhttps://leetcode.com/problems/partition-labels/
   Date: 27th Jan 2022. First greedy approach, 

*/
import java.util.*;

class PartitionLabel_763 {
    public List<Integer> partitionLabels(String s) {
        //  partition as many parts as possible  (DP, greedy?) if all the letters were different. 

        // each letter should appear in atmost one part. 

        // i guess this is my first greedy problem. 

        // one point to learn here, this method needs to return List<Integer> so creating one Integer array list doesn't really count as an space. so even creating an ArrayList of integers, its counted as constant space time complexity . 


        // for each letter of the algorithm, process the last occurrence of that letter extending the current partition appropriately. 

        // this is a genious yes simple algorithm for getting the last index of the string 

        int[] lastIndex = new int[26];

        for (int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i)- 'a'] = i; // i loooove it. 
        }

        int start =0;
        int end =0;

        List<Integer> sol = new ArrayList<>();

        for (int i =0; i<s.length(); i++){
            end = Math.max(end, lastIndex[s.charAt(i)-'a']);
            if (i == end ){
                sol.add(end-start+1);
                start = end+1;
            } // i Really love this sum and approch, Just think searching for the greedy thing. 

        }
        return sol;



    }
}