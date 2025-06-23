package com.multi.baekjoon.brute_force;


import java.io.*;

public class P_17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 1;

        while(start<=n){

            String numStr = String.valueOf(start);

            for(int i=0;i<numStr.length();i++){
                if(numStr.charAt(i)=='3')
                    count++;
                else if(numStr.charAt(i)=='6')
                    count++;
                else if(numStr.charAt(i)=='9')
                    count++;
            }
            start++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
