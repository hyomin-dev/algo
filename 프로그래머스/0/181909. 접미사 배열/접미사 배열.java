import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] arr = new String[my_string.length()];
        
        for(int i=my_string.length()-1;i>=0;i--){
            arr[i] = my_string.substring(i);
        }
        
        Arrays.sort(arr);
        
        return arr;
    }
}