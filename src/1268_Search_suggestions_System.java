class Solution {
    // helper method to find the first index product[i] >= prefix
    int lower_bound (String[] products, int start, String prefix){
        int left = start, right = products.length; 
        while(left < right){
            int mid = (left+right)/2;

            if(products[mid].compareTo(prefix) >=0){
                right = mid; 
            }
            else{
                left = mid+1;
            }
        }
        return left; 
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products); // nlogn
        List<List<String>> result = new ArrayList<>(); 
        int start = 0, n = products.length; 
        StringBuilder  prefix = new StringBuilder();
         
        for(char c : searchWord.toCharArray()){
            prefix.append(c);
            String currentPrefix = prefix.toString();
            int startIndex = lower_bound(products,start, currentPrefix);

            List<String> sugg = new ArrayList<>(); 
            for( int i = startIndex; i < Math.min(startIndex+3, products.length); i++ ){
                if(products[i].startsWith(currentPrefix)){
                    sugg.add(products[i]);
                }else{
                    break;
                }
            }
            result.add(sugg);
            start = startIndex; 
        }
         return result;
    }    
}
/**
1. Sort the product lexicographically 
2. for each char in searchWord, build prefix
3. use BS( ) to find the first index of product starting with that prefix 
4. from that index collect upto 3 matching prodocts 
5. use previously found index (bsStart) to narrow the search space (greedy)

_>lower_bound is an algorithm that returns the first position/index where a given value can be inserted without violating the sort order.

*/
