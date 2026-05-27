class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        String kStr = String.valueOf(k);
        
        for(int n=i;n<=j;n++){
            String[] nSplitArr = String.valueOf(n).split("");            
            for(String str:nSplitArr){
                if(str.equals(kStr))
                    count++;
            }
            
        }
        
        return count;
    }
}