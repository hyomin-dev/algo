import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list).mapToObj(Integer::valueOf).collect(Collectors.toList());
        int num;
        
        if(num_list[num_list.length-1]>num_list[num_list.length-2])
            num = num_list[num_list.length-1] - num_list[num_list.length-2];
        else
            num = num_list[num_list.length-1]*2;
        
        list.add(num);
        
        return list.stream().mapToInt(Integer::valueOf).toArray();
        
    }
}