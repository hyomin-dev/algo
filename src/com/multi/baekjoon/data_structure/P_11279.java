package com.multi.baekjoon.data_structure;

import java.io.*;
import java.util.*;

public class P_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(n>0){

            int x = Integer.parseInt(br.readLine());

            if(x==0){
                if(pq.isEmpty())
                    bw.write("0\n");
                else
                    bw.write(pq.poll()+"\n");
            }else{
                pq.offer(x);
            }

            n--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
