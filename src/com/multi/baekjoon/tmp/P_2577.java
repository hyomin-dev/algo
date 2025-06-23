package com.multi.baekjoon.tmp;


import java.io.*;

public class P_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int num3 = Integer.parseInt(br.readLine());

        int result = num1*num2*num3;
        String[] strArray = String.valueOf(result).split("");

        for(int i=0;i<=9;i++){
            int count =0;

            for(String s: strArray){
                if(String.valueOf(i).equals(s))
                    count++;
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
