class Solution {
    public String solution(String my_string, int[] index_list) {
        StringBuilder strBuilder = new StringBuilder();
        
        for(int num : index_list){
            strBuilder.append(String.valueOf(my_string.charAt(num)));
        }
        
        return strBuilder.toString();
    }
}