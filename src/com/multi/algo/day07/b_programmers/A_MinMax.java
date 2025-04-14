package com.multi.algo.day07.b_programmers;


public class A_MinMax {
    public static void main(String[] args) {
        A_MinMax aMinMax = new A_MinMax();
        aMinMax.solution(7);
    }

    public int solution(int n) {
        int answer = 0;

        for(int i=n;i>0;i--)
            if(n>=factorial(i)){
                answer = i;
                break;
            }

        return answer;
    }

    public int factorial(int n){
        if(n>0)
            return n*factorial(n-1);
        else
            return 1;
    }
}
