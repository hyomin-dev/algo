import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[]{-1};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int startIdx = -1, endIdx=-1;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==2){
                startIdx = i;
                break;
            }
        }
        
        if(startIdx==-1)
            return answer;
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==2){
                endIdx = i;
                break;
            }
        }        
        
        for(int i=startIdx;i<=endIdx;i++){
            list.add(arr[i]);
        }     
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}