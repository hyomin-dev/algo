package com.multi.baekjoon.tmp;


import java.io.*;

public class P_17427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        long sum = 0;

        for(int i=1;i<=num;i++){
           sum = sum+(long)(num/i)*i;
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
*
* f(1) = sum(1)
* f(2) = sum(2)
* f(3) = sum(1,3)
* f(4) = sum(1,2,4)
* f(5) = sum(1,5)
* f(6) = sum(1,2,3,6)
* f(7) = sum(1,7)
* f(8) = sum(1,2,4,8)
* N/i는 i가 등장한 횟수
* 그러므로 i가 등장한 횟수 * i를 해주면 i에 대한 합
* 이를 1~N까지 고려해서 더해주면 g(n)을 구할 수 있음
* */


