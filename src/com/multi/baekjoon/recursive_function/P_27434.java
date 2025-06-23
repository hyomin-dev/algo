package com.multi.baekjoon.recursive_function;


import java.io.*;
import java.math.BigInteger;

public class P_27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n==0){
            bw.write("1");

        } else if(n<=20){
            int result = 1;
            for(int i=2;i<=n;i++)
                result *=i;
            bw.write(String.valueOf(result));
        }
        else{
            BigInteger result = new BigInteger("1");
            for(long i=2;i<=n;i++)
                result = result.multiply(BigInteger.valueOf(i));
            bw.write(result.toString());
        }

        bw.flush();
        bw.close();
        br.close();

    }

}
