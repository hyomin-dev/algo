class Solution {
    public String solution(String str1, String str2) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(int i=0;i<str1.length();i++){
            strBuilder.append(String.valueOf(str1.charAt(i)));
            strBuilder.append(String.valueOf(str2.charAt(i)));
        }
        
        return strBuilder.toString();
    }
}