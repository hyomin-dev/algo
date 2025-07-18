package com.multi.baekjoon.simulation;


import java.io.*;

public class P_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(n>0){
            boolean[] array = new boolean[26];

            String str = br.readLine();

            char curr = '.';

            for(int i=0;i<str.length();i++){
                if(curr!=str.charAt(i)){
                    curr = str.charAt(i);
                    if(array[curr-'a']) // 이전에 이미 찾은 문자
                        break;
                    else
                        array[curr-'a'] = true;
                }

                if(i==str.length()-1)
                    count++;
            }
            n--;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
