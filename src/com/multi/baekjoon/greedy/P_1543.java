package com.multi.baekjoon.greedy;


import java.io.*;

public class P_1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String document = br.readLine();
        String findStr = br.readLine();

        int idx=0; // document내에서 위치를 이동하는 인덱스 역할
        int count = 0; // 찾는 단어의 갯수
        while(idx<=(document.length()-findStr.length())){

            String compareStr = document.substring(idx,idx+findStr.length());

            if(findStr.equals(compareStr)){
                count++;
                idx += findStr.length();
            }else
                idx++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
