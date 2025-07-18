package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.ArrayList;

public class P_9506 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){

            int n = Integer.parseInt(br.readLine());

            if(n==-1)
                break;

            int sum=0;
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=1;i<n;i++){
                if(n%i==0) {
                    sum += i;
                    list.add(i);
                }
            }

            if(sum==n){
                bw.write(n +" = ");
                for(int i=0;i<list.size()-1;i++){
                    bw.write(list.get(i)+" + ");
                }
                bw.write(list.get(list.size()-1)+"");

            }else{
                bw.write(n+" is NOT perfect.");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
