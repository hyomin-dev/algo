package com.multi.baekjoon.prepare_base;


import java.io.*;
import java.util.StringTokenizer;

public class P_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int lcm = -1; // 최소공배수
        int gcd = 1; // 최대 공약수

        for(int i=1;i<=num1*num2;i++){
            if(num1%i==0&&num2%i==0)
                gcd = i;
            if(i%num1==0&&i%num2==0&&lcm==-1)
                lcm = i;

            if(lcm!=-1)
                break;

        }

        bw.write(String.valueOf(gcd));
        bw.newLine();
        bw.write(String.valueOf(lcm));
        bw.flush();
        bw.close();
        br.close();



    }
}
