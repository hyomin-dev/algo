class Solution {
    public int solution(String binomial) {
         String[] strArray = binomial.split(" ");
       int answer;

       if(strArray[1].equals("+")){
           answer = Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2]);
       }else if(strArray[1].equals("-")){
           answer = Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2]);
       }else{
           answer = Integer.parseInt(strArray[0]) * Integer.parseInt(strArray[2]);
       }

       return answer;
    }
}