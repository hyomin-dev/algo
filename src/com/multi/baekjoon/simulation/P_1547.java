package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_1547 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine()); // 1 <= m <= 50

        int cupWithBall = 1;

        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(num1 == cupWithBall)
                cupWithBall = num2;
            else if(num2 == cupWithBall)
                cupWithBall = num1;

        }

        bw.write(String.valueOf(cupWithBall));
        bw.flush();
        bw.close();
        br.close();

    }
}
