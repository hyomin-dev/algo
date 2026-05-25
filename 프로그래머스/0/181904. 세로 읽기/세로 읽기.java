class Solution {
    public String solution(String my_string, int m, int c) {
        // c-1, c-1+m
        
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i=c-1;i<my_string.length();i+=m){
            strBuilder.append(String.valueOf(my_string.charAt(i)));
        }
        
        return strBuilder.toString();
    }
}