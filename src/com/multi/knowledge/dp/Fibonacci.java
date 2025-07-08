package com.multi.knowledge.dp;


import java.util.Scanner;

public class Fibonacci {
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        array = new int[num+1];

        System.out.println(fibo(num));
        System.out.println(fibo2(num));

    }

    static int fibo(int x){
        if(x<=2)
            return 1;
        if(array[x]!=0)
            return array[x];
        array[x] = fibo(x-1) + fibo(x-2);
        return array[x];

    }
    static int fibo2(int x){
        int[] array2 = new int[x+1];
        array2[1] = 1;
        array2[2] = 1;

        for(int i=3;i<=x;i++)
            array2[i] = array2[i-1] + array2[i-2];
        return array2[x];
    }
}
