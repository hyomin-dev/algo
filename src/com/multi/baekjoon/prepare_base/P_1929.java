package com.multi.baekjoon.prepare_base;


import java.io.*;
import java.util.StringTokenizer;

public class P_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=M;i<=N;i++){
            if(i==1)
                continue;
            else if(i%2==0)
                continue;

            boolean isDecimal = true;

            for(int j=2;j<i;j++){
                if(i%j==0){
                    isDecimal = false;
                    break;
                }
            }

            if(isDecimal){
                bw.write(String.valueOf(i));
                bw.newLine();
            }

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
