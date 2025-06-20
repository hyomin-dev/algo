package com.multi.baekjoon.prepare_base;


import java.io.*;
import java.util.StringTokenizer;

public class P_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int nums = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count=0;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num==1){
                continue;
            }
            boolean isDecimal = true;
            for(int i=2;i<num;i++){

                if(num%i==0){
                    isDecimal = false;
                    break;
                }
            }
            if(isDecimal)
                count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        br.close();

    }
}
