package com.multi.baekjoon.tmp;


import java.io.*;

public class P_2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>=97)
                bw.write(str.charAt(i)-32);
            else
                bw.write(str.charAt(i)+32);

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
