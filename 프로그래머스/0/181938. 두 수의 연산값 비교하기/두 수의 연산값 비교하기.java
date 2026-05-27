class Solution {
    public int solution(int a, int b) {
        int number1, number2;
        
        number1 = Integer.parseInt(String.valueOf(a)+String.valueOf(b));
        number2 = 2*a*b;
        
        if(number1>number2)
            return number1;
        else
            return number2;
    }
}