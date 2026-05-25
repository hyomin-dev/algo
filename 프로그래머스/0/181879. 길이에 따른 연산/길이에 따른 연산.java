class Solution {
    public int solution(int[] num_list) {
        int sum;
        
        if(num_list.length>=11){            
            sum = 0;
            for(int num: num_list)
                sum+=num;
        }else{
            sum = 1;
            for(int num:num_list)
                sum *=num;
        }
        
        return sum;
    }
}