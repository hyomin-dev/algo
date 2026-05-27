class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder strBuilder = new StringBuilder(my_string);
        
        for(int idx:indices){
            strBuilder.replace(idx,idx+1," ");
        }
        
        String[] strArr = strBuilder.toString().split(" ");
        
        strBuilder.setLength(0);
        
        for(String str:strArr){
            strBuilder.append(str);
        }
        
        return strBuilder.toString();
        
    }
}