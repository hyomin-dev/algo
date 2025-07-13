package com.multi.baekjoon.dp;


import java.io.*;

public class P_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n<=2)
            bw.write("1");
        else{
            long[] array = new long[n+1];
            array[1] = 1;
            array[2] = 1;
            for(int i=3;i<=n;i++)
                array[i] = array[i-1] + array[i-2];
            bw.write(String.valueOf(array[n]));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
n자리의 이친수:
n-1자리 이친수: 1 다음은 0부터 시작함, 이 0부터 시작하는 수들이 n자리의 이친수에서 그대로 사용됨
n-2자리 이친수: 1부터 시작하는 이친수, 이 이친수 들이 n자리의 이친수에서 그대로 사용됨

그래서 피보나치 수열로 풀음

*
* */
