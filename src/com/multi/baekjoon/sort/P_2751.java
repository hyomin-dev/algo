package com.multi.baekjoon.sort;


import java.io.*;
import java.util.Arrays;

public class P_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for(int i=0;i<n;i++)
            array[i] = Integer.parseInt(br.readLine());

        Arrays.sort(array);
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(array[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }


}
