package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int continuousCircle = 1;
            int sum = 0;
            String answer = st.nextToken();

            for(int i=0;i<answer.length();i++){
                if(answer.charAt(i)=='O'){
                    sum +=continuousCircle;
                    continuousCircle++;
                }else{
                    continuousCircle=1;
                }
            }


            bw.write(sum+"\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
