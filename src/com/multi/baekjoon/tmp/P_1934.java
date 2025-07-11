package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            bw.write(findLCS(a, b) + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static long findLCS(long a, long b){
        long lcs = a*b;
        for(long i=a;i<lcs;i=i+a){
            if(i%b==0)
                return i;
        }
        return lcs;
    }
}
