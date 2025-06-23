package com.multi.baekjoon.tmp;


import java.io.*;

public class P_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        if(num==0){
            bw.write(String.valueOf(1));
        }else{

            int result = 1;
            for(int i=1;i<=num;i++)
                result = result*i;
            bw.write(String.valueOf(result));
        }
        bw.flush();
        bw.close();
        br.close();


    }
}
