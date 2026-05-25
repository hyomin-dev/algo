class Solution {
    public String solution(int[] numLog) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i=0;i<numLog.length-1;i++){
            int diff = numLog[i+1] - numLog[i];
            String str;
            if(diff==1)
                str = "w";
            else if(diff==-1)
                str = "s";
            else if(diff==10)
                str = "d";
            else
                str = "a";
            strBuilder.append(str);
        }
        
        return strBuilder.toString();
    }
}