class Solution {
    public int solution(int[] array, int n) {
        int minDiff = Math.abs(array[0]-n);
        int minIdx = 0;
        
        for(int i=1;i<array.length;i++){
            int diff = Math.abs(array[i]-n);
            
            if(diff==minDiff){
                if(array[minIdx]>array[i])
                    minIdx = i;
            }else if(diff<minDiff){
                minDiff = diff;
                minIdx = i;
            }
            
        }
        
        return array[minIdx];
        
        
    }
}