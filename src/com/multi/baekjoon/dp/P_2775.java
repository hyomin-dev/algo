package com.multi.baekjoon.dp;


import java.io.*;

public class P_2775 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        int t = Integer.parseInt(br.readLine());

        while(t>0){
            int[] dpTable = new int[14+1];

            for(int i=0;i<15;i++)
                dpTable[i] = i;

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            for(int i=1;i<=k;i++){
                for(int j=1;j<15;j++){
                    if(j==1)
                        dpTable[j] = 1;
                    else{
                        dpTable[j] = dpTable[j-1]+dpTable[j];
                    }

                    if(i==k&&j==n)
                        break;
                }
            }

            bw.write(dpTable[n]+"\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
