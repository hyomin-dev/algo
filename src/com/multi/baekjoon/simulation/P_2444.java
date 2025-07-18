package com.multi.baekjoon.simulation;


import java.io.*;

public class P_2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            for(int j=0;j<2*n-1;j++){
                if(n-1-i<=j&&j<=n-1+i)
                    bw.write("*");
                else if(n-1-i>j)
                    bw.write(" ");

            }
            bw.newLine();
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<2*n-1;j++){
                if(n-1-i<=j&&j<=n-1+i)
                    bw.write("*");
                else if(n-1-i>j)
                    bw.write(" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
