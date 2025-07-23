package com.multi.baekjoon.simulation;

import java.io.*;
import java.util.*;

public class P_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(n>=b){

            int r = n%b;
            n = n/b;

            if(r<10){
                sb.append(String.valueOf(r));
            }else{
                sb.append((char)(r+55));
            }

        }
        if(n<10){
            sb.append(String.valueOf(n));
        }else{
            sb.append((char)(n+55));
        }

        String nStr = sb.toString();
        for(int i=nStr.length()-1;i>=0;i--)
            bw.write(nStr.charAt(i));

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

각 자리의 숫자마다 곱해야하는 수
1
1*b
1*b*b

0~9인 경우: 그대로 숫자 사용

A: 65
Z: 90
A~Z인 경우: 변환

문자 - '65' + 10


* */
