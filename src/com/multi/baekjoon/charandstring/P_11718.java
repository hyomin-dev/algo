package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_11718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str;
        while((str= br.readLine())!=null){
            bw.write(str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
