package com.multi.baekjoon.prepare_base;


import java.io.*;

public class P_4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str=br.readLine())!=null&&!str.isEmpty()){

            int n = Integer.parseInt(str);


            if(n==1){
                bw.write("1");
                bw.newLine();
            }else{
                int idx = 1;
                int sum = 1;

                while(true){

                    sum +=(Math.pow(10,idx))%n;

                    if(sum%n==0){
                        bw.write(String.valueOf(idx+1));
                        bw.newLine();
                        break;
                    }
                    idx++;

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