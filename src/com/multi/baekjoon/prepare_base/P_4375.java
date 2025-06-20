package com.multi.baekjoon.prepare_base;


import java.io.*;

public class P_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str=br.readLine())!=null&&!str.isEmpty()){

            StringBuilder stringBuilder = new StringBuilder("1");
            int n = Integer.parseInt(str);

            while(true){
                long oneNum = Long.parseLong(stringBuilder.toString());
                if(oneNum%n==0 && oneNum>n){
                    bw.write(String.valueOf(stringBuilder.toString().length()));
                    bw.newLine();
                    break;
                }else{
                    stringBuilder.append("1");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}



/*
 * (a + b) % m = (a % m + b % m ) % m
 * */