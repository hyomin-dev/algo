package com.multi.baekjoon.charandstring;


import java.io.*;

public class P_5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        int sum = 0;
        for(int i=0;i<str.length();i++){

           if('A'<=str.charAt(i) && str.charAt(i)<='C')
               sum+=3;
           else if ('D'<=str.charAt(i) && str.charAt(i)<='F')
               sum+=4;
           else if ('G'<=str.charAt(i) && str.charAt(i)<='I')
               sum+=5;
           else if ('J'<=str.charAt(i) && str.charAt(i)<='L')
               sum+=6;
           else if ('M'<=str.charAt(i) && str.charAt(i)<='O')
               sum+=7;
           else if ('P'<=str.charAt(i) && str.charAt(i)<='S')
               sum+=8;
           else if ('T'<=str.charAt(i) && str.charAt(i)<='V')
               sum+=9;
           else if ('W'<=str.charAt(i) && str.charAt(i)<='Z')
               sum+=10;


        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}
