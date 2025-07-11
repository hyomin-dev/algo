package com.multi.baekjoon.dp;


import java.io.*;

public class P_24416 {
    static int count1 = 0;
    static int count2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);

        bw.write(count1+" "+count2);
        bw.flush();
        bw.close();
        br.close();

    }

    static int fib(int n){
        if(n<=2) {
            count1++;
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    static int fibonacci(int n){
        if(n<=2)
            return 1;
        int[] array = new int[n+1];
        array[1] = 1;
        array[2] = 1;
        for(int i=3;i<=n;i++) {
            count2++;
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n];
    }
}
