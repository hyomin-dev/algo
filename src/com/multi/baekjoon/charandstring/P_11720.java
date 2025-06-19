package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int sum=0;
        for(int i=0;i<num;i++){
            sum += Integer.parseInt(str.charAt(i)+"");
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();

    }
}
