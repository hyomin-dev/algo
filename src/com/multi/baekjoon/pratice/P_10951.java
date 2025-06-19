package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_10951 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str=br.readLine())!=null&&!str.isEmpty()){
            StringTokenizer st = new StringTokenizer(str);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(num1+num2));
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
