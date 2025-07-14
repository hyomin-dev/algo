package com.multi.baekjoon.geo;


import java.io.*;
import java.util.StringTokenizer;

public class P_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s1 = Integer.parseInt(st.nextToken());

            if(s1==0)
                break;

            int s2 = Integer.parseInt(st.nextToken());
            int s3 = Integer.parseInt(st.nextToken());

            // s1, s2 ,s3의 제곱
            int s1s1 = s1*s1;
            int s2s2 = s2*s2;
            int s3s3 = s3*s3;

            // s1 이 가장 큰 경우
            if(s1s1==s2s2+s3s3){
                bw.write("right");
            }else if(s2s2==s1s1+s3s3)
                bw.write("right");
            else if(s3s3==s1s1+s2s2)
                bw.write("right");
            else
                bw.write("wrong");
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
