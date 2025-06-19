package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer[] intArray = new Integer[num];
        int i =0;
        while(st.hasMoreTokens()){
            intArray[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArray);

        bw.write(String.valueOf(intArray[0]));
        bw.write(" ");
        bw.write(String.valueOf(intArray[num-1]));
        bw.flush();
        bw.close();
        br.close();


    }
}
