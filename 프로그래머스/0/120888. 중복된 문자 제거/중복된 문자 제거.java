class Solution {
    public String solution(String my_string) {
        int[] lowerAlp = new int[26]; // a: 97 z: 112
        int[] upperAlp = new int[26]; // A: 65 Z: 90
        boolean findSpace = false;
        
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i=0;i<my_string.length();i++){
            char ch = my_string.charAt(i);
            
            if(ch==' '){
                if(!findSpace){
                    strBuilder.append(ch+"");
                    findSpace = true;
                }
            }else if(ch>=65&&ch<=90){
                if(lowerAlp[ch-65]==0){
                    strBuilder.append(ch+"");
                    lowerAlp[ch-65]+=1;
                }
            }else{
                if(upperAlp[ch-97]==0){
                    strBuilder.append(ch+"");
                    upperAlp[ch-97]+=1;
                }
            }                    
            
        }
        
        return strBuilder.toString();
        
    }
}