package com.multi.baekjoon.dp;


import java.io.*;

public class P_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 1 <= n <= 1000
        if(n<=2){
            bw.write(String.valueOf(n));
        }else{
            long[] array = new long[n+1];
            array[1] = 1;
            array[2] = 2;
            for(int i=3;i<=n;i++)
                array[i] = (array[i-2] + array[i-1])%10007;
            bw.write(String.valueOf(array[n]));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

n=1 --> 2x1
n=2 ---> 2x1 2개, 1x2 2개


규칙: 오른쪽에 더하기가 핵심
--> 2개를 더해야 하는 경우: 1x2 2개를 오른쪽에 더한다.
--> 1개를 더해야 하는 경우 2x1 1개를 오른쪽에 더한다.


* */
