class Solution {
    public int solution(String num_str) {
        int sum = 0;

        for(int i=0;i<num_str.length();i++){
            int num = Integer.parseInt(String.valueOf(num_str.charAt(i)));
            sum+=num;
        }
        return sum;
    }
}