class Solution {
    public String solution(String my_string, int k) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i=0;i<k;i++){
            strBuilder.append(my_string);
        }
        
        return strBuilder.toString();
    }
}