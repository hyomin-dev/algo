import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int element: arr){
            for(int i=0;i<element;i++){
                list.add(element);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}