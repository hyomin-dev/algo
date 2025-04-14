package com.multi.algo.day07.d_recursion;


public class A_Recur2 {
    public static void main(String[] args) {
        int x = 5;
        recur(x);

    }

    private static void recur(int x) {
        while(x>0){
            System.out.println(x--);

        }
    }
}
