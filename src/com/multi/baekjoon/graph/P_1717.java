package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_1717 {

    static int[] parents;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];

        for(int i=1;i<=n;i++) // 자기 자신을 부모로 초기화
            parents[i] = i;

        while(m>0){
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            if(command==0)
                unionParent(n1,n2);
            else{
                int n1Root = findParent(n1);
                int n2Root = findParent(n2);
                if(n1Root==n2Root)
                    bw.write("YES\n");
                else
                    bw.write("NO\n");
            }
            m--;
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int findParent(int x){ //루트 노드를 찾음, 경로 압축을 적용하여 부모노드 대신 루트 노드 저장
        if(x!=parents[x])
            parents[x] = findParent(parents[x]);
        return parents[x];
    }

    static void unionParent(int n1, int n2){

        int n1Root = findParent(n1);
        int n2Root = findParent(n2);

        if(n1Root<n2Root) // 더 작은 쪽이 부모가 되도록
            parents[n2Root] = n1Root;
        else
            parents[n1Root] = n2Root;

    }
}
