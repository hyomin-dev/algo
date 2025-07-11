package com.multi.baekjoon.dp;


import java.io.*;

public class P_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n==1)
            bw.write(String.valueOf(10));
        else{
            long[] array = new long[10];
            for(int col=0;col<10;col++)
                array[col] = 1;

            for(int i=0;i<n-1;i++){
                for(int col=0;col<10;col++){
                    long sum = 0;
                    for(int j=9;j>=col;j--)
                        sum +=array[j];
                    array[col] = sum%10007;
                }
            }

            long result = 0;
            for(int col=0;col<10;col++)
                result +=array[col];

            bw.write(String.valueOf(result%10007));
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
