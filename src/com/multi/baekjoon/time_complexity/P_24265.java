package com.multi.baekjoon.time_complexity;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class P_24265 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        BigInteger i = new BigInteger(String.valueOf(n));
        BigInteger result;
        result = i.multiply(i);
        result = result.multiply(i);

        bw.write(result.toString());
        bw.write("\n3");

        bw.flush();
        bw.close();
        br.close();

    }
}
