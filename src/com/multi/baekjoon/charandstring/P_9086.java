package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int i=0;
        while(i<num){

            String str = br.readLine();
            bw.write(str.charAt(0));
            bw.write(str.charAt(str.length()-1));
            bw.newLine();

            i++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
