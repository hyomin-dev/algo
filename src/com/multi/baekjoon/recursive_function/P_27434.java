package com.multi.baekjoon.recursive_function;


import java.io.*;
import java.math.BigInteger;

public class P_27434 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("1");

        for(int i=2;i<=n;i++)
            result = result.multiply(BigInteger.valueOf(i));

        System.out.println(result);

    }

}
