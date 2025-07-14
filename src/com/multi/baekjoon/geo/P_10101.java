package com.multi.baekjoon.geo;


import java.io.*;

public class P_10101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s1 = Integer.parseInt(br.readLine());
        int s2 = Integer.parseInt(br.readLine());
        int s3 = Integer.parseInt(br.readLine());

        if(s1==60&&s2==60&&s3==60)
            bw.write("Equilateral");
        else if(s1+s2+s3==180&&(s1==s2||s1==s3||s2==s3))
            bw.write("Isosceles");
        else if(s1+s2+s3==180&&(s1!=s2&&s1!=s3&&s2!=s3))
            bw.write("Scalene");
        else if(s1+s2+s3!=180)
            bw.write("Error");

        bw.flush();
        bw.close();
        br.close();

    }
}
