package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] answer = new int[]{1,1,2,2,2,8};
        int[] array = new int[6];
        int i =0;
        while(st.hasMoreTokens()){
            array[i++] = Integer.parseInt(st.nextToken());
        }

        for(int j=0;j<6;j++)
            bw.write(answer[j]-array[j]+" ");
        bw.flush();
        bw.close();
        br.close();

    }
}
