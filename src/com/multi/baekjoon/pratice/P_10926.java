package com.multi.baekjoon.pratice;


import java.io.*;
import java.util.StringTokenizer;

public class P_10926 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            String str = st.nextToken() + "??!";
            bw.write(str);
        }
        bw.close();
        br.close();


    }
}
