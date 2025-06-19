package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

         int numT = Integer.parseInt(br.readLine());

         int i=0;
         while(i<numT){
             StringTokenizer st = new StringTokenizer(br.readLine());
             int num1 = Integer.parseInt(st.nextToken());
             int num2 = Integer.parseInt(st.nextToken());

             bw.write((num1+num2)+"");
             bw.newLine();
             i++;
         }

         bw.close();
         br.close();

    }
}
