package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for(int i=97;i<123;i++){

            boolean isContained = false;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)==i){
                    bw.write(String.valueOf(j));
                    isContained =true;
                    break;
                }
            }

            if(!isContained)
                bw.write(String.valueOf(-1));

            bw.write(" ");

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
