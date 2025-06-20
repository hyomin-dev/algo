package com.multi.baekjoon.prepare_base;


import java.io.*;

public class P_17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int sum = 0;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=i;j++){
                if(i%j==0)
                    sum +=j;
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();

    }
}

/*
*
* x>=y
* 모든 y의 f(y)를 더 한 값은 g(x)로 표현
*
*  1, 2, 3, 4, 5, 6,
* */


