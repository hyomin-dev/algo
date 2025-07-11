package com.multi.baekjoon.dp;


import java.io.*;

public class P_11727 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n==1)
            bw.write(String.valueOf(1));
        else if(n==2)
            bw.write(String.valueOf(3));
        else{
            long[] array = new long[n+1];
            array[1] = 1;
            array[2] = 3;
            for(int i=3;i<=n;i++){
                array[i] = (array[i-1]+array[i-2]*2)%10007;
            }

            bw.write(String.valueOf(array[n]));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
