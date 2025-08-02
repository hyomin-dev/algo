package com.multi.baekjoon.graph;


import java.io.*;
import java.util.*;

public class P_1976 {

    static int[] parents;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        for(int i=1;i<=n;i++)
            parents[i] = i;

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1;j<=n;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==0)
                    continue;

                unionParent(i,j);

            }
        }

        // 여행 계획에 속한 도시들의 루트 노드가 모두 같다면 여행 가능

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken()); // 처음 방문 도시

        int root = parents[first]; // 처음 방문 도시의 루트 노드

        boolean isPossible = true;
        while(m>1){
            int now = Integer.parseInt(st.nextToken());
            int nowRoot = parents[now];

            if(root!=nowRoot){
                isPossible = false;
                break;
            }
            m--;
        }

        if(isPossible)
            bw.write("YES");
        else
            bw.write("NO");

        bw.flush();
        bw.close();
        br.close();

    }

    static void unionParent(int n1, int n2){

        int n1Root = findParent(n1);
        int n2Root = findParent(n2);

        if(n1Root<n2Root) // n1의 루트 노드가 더 작다면, n1Root가 루트노드가 됨
            parents[n2Root] = n1Root;
        else
            parents[n1Root] = n2Root;

    }

    static int findParent(int x){ // 경로 단축 적용 --> 부모 테이블에 루트 노드가 담김
        if(x!=parents[x])
            parents[x] = findParent(parents[x]);
        return parents[x];
    }
}
