package com.multi.baekjoon.prepare_base;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] intArray = new int[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0;
        while(st.hasMoreTokens()){
            intArray[i] = Integer.parseInt(st.nextToken());
            i++;
        }

        Arrays.sort(intArray);
        bw.write(String.valueOf(intArray[0]*intArray[num-1]));
        bw.flush();
        bw.close();
        br.close();

    }
}
