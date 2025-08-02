package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_20040 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 3 <= n <= 500,000
        int m = Integer.parseInt(st.nextToken()); // 3 <= m <= 1,000,000

        int[] parents = new int[n]; // 노드 번호는 0부터

        for(int i=0;i<n;i++) // 자기 자신을 부모로
            parents[i] = i;

        int order = 0;
        boolean isCycle = false;

        for(int i=1;i<=m;i++){

            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            int node1Root = findParent(parents, node1);
            int node2Root = findParent(parents, node2);

            if(node1Root == node2Root){
                if(!isCycle) {
                    isCycle = true;
                    order = i;
                }
            }else if(node1Root<node2Root)
                    parents[node2Root] = node1Root;
            else if(node1Root > node2Root)
                parents[node1Root] = node2Root;

        }

        bw.write(order+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static int findParent(int[] parents, int x){
        if(x!=parents[x])
            parents[x] = findParent(parents, parents[x]);
        return parents[x];
    }

}
