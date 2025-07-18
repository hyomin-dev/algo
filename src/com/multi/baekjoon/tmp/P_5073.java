package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_5073 {
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

            int longestSide = Math.max(s1,Math.max(s2,s3));
            int sum = s1+s2+s3;

            if(longestSide>=sum-longestSide)
                bw.write("Invalid\n");
            else if(s1==s2&&s2==s3)
                bw.write("Equilateral\n");
            else if(s1==s2||s1==s3||s2==s3)
                bw.write("Isosceles\n");
            else
                bw.write("Scalene\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }
}
