import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
       int[] reverseArr = Arrays.stream(emergency.clone()).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::valueOf).toArray();
        
        int[] answer = new int[emergency.length];
        
        for(int i=0;i<emergency.length;i++){
            for(int j=0;j<emergency.length;j++){
                if(reverseArr[i]==emergency[j]){
                    answer[j] = i+1;
                    break;
                }
            }
        }      
                           
        return answer;
    }
}