package com.multi.baekjoon.data_structure;

import java.util.*;
import java.io.*;

public class P_1966 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t =Integer.parseInt(br.readLine());

        while(t>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<int[]> q = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            for(int i=0;i<n;i++){
                int x = Integer.parseInt(st.nextToken());

                pq.offer(x);
                q.offer(new int[]{x,i});
            }

            int count = 1;
            while(!pq.isEmpty()){
                int x = pq.poll();

                int[] qX;

                while(true){
                    qX = q.poll();

                    if(x==qX[0])
                        break;
                    else
                        q.offer(qX);
                }

                if(qX[1]==m)
                    break;
                else
                    count++;

            }

            bw.write(count+"\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
pq: 4 3 2 1
q: 1 2 3 4

* */