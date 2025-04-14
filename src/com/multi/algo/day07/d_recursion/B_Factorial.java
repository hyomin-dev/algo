package com.multi.algo.day07.d_recursion;


public class B_Factorial {
    // 팩토리얼 값을 재귀적으로 구함
        //n! = n × (n - 1) × (n - 2) × ... × 1
        //        0! = 1

            //factorial(5)
        //→ 5 * factorial(4)
        //→ 5 * (4 * factorial(3))
        //        → 5 * (4 * (3 * factorial(2)))
        //        → 5 * (4 * (3 * (2 * factorial(1))))
        //        → 5 * (4 * (3 * (2 * (1 * factorial(0)))))
        //        → 5 * (4 * (3 * (2 * (1 * 1))))  ← factorial(0)은 1 반환
        //→ 5 * 4 * 3 * 2 * 1 = 120
    public static void main(String[] args) {
        int x = 5;
        System.out.println(x + "!>> " + factorial(x));
    }

    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else//n == 0일 때 재귀를 멈추고 1을 반환함
            return 1;
    }



}
