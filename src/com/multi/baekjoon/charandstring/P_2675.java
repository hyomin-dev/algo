package com.multi.baekjoon.charandstring;


import java.io.*;
import java.util.StringTokenizer;

public class P_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numTest = Integer.parseInt(br.readLine());

        int count = 0;
        while(count<numTest){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i=0; i<str.length();i++){
                for(int j=0;j<num;j++){
                    bw.write(str.charAt(i));
                }
            }

            bw.newLine();

            count++;

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
