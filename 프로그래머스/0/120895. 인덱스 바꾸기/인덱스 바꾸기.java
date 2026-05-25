class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder stringBuilder = new StringBuilder(my_string);

        String strNum1 = String.valueOf(my_string.charAt(num1));
        String strNum2 = String.valueOf(my_string.charAt(num2));

        stringBuilder.replace(num1,num1+1,strNum2);
        stringBuilder.replace(num2,num2+1,strNum1);

        return stringBuilder.toString();
    }
}