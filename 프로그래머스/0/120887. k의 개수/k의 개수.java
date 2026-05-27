class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        String kStr = String.valueOf(k);
        
        for(int n=i;n<=j;n++){
            String nStr = String.valueOf(n);            
            for(int idx=0;idx<nStr.length();idx++){
                String str = String.valueOf(nStr.charAt(idx));
                if(str.equals(kStr))
                    count++;
            }
            
        }
        
        return count;
    }
}