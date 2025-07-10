package com.multi.baekjoon.simulation;


import java.io.*;

public class P_10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean palindrome = true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                palindrome=false;
                break;
            }
        }
        if(palindrome)
            bw.write("1");
        else
            bw.write("0");

        bw.flush();
        bw.close();
        br.close();
    }
}
