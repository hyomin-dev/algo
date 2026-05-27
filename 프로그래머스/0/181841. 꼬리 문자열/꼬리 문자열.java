class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(String str: str_list){
            if(!str.contains(ex))
                strBuilder.append(str);
        }
        
        return strBuilder.toString();
    }
}