class Solution {
    public String solution(String myString) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i=0;i<myString.length();i++){
            char ch = myString.charAt(i);
            
            if(ch<'l')
                strBuilder.append("l");
            else
                strBuilder.append(String.valueOf(ch));
        }
        
        return strBuilder.toString();
    }
}