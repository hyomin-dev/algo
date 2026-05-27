import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++){
            int num = arr[i];
            if(flag[i]){                
                for(int j=0;j<2*num;j++)
                    list.add(list.size(),num);
            }else{
                while(num>0){
                    list.remove(list.size()-1);
                    num--;
                }
            }
        }
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
        
    }
}