class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        for(int num:num_list){
            int count = 0;
            while(true){
                if(num==1){
                    answer+=count;
                    break;
                }                    
                
                if(num%2==0){
                    num/=2;
                    count++;
                }                               
                else{
                    num-=1;
                    num/=2;
                    count++;
                }
            }
        }
        
        return answer;
    }
}