class Solution {
    public int solution(int a, int b, int c) {
        
        int answer = 0;
        // 세 숫자가 모두 다른 경우
        if(a!=b && a!=c &&b!=c)
            answer = a+b+c;        
        // 세 숫자가 모두 같은 경우
        else if(a==b&&b==c){
            answer = (a+b+c)*(a*a+b*b+c*c)*(a*a*a+b*b*b+c*c*c);
        }else{
            answer = (a+b+c)*(a*a+b*b+c*c);
        } 
        
        return answer;
    }
}