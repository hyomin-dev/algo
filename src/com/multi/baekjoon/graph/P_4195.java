package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_4195 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t>0){
            int f = Integer.parseInt(br.readLine());
            int currNodeNum = 1;
            int[] parents = new int[2*f+1]; // 2*f= 최대 사람 수, +1은 인덱스를 1부터 시작하기 위함
            int[] size = new int[2*f+1];
            for(int i=1;i<=2*f;i++) {
                parents[i] = i;
                size[i] = 1;
            }
            Map<String, Integer> map = new HashMap<>(); // 이름과 자기 자신의 인덱스를 저장함

            for(int i=0;i<f;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                String p2 = st.nextToken();
                if(map.getOrDefault(p1,0)==0){ // map에 저장되지 않은 이름이 들어온 경우
                    map.put(p1, currNodeNum++);
                }

                if(map.getOrDefault(p2,0)==0){ // map에 저장되지 않은 이름이 들어온 경우
                    map.put(p2, currNodeNum++);
                }

                unionParent(parents,map.get(p1),map.get(p2),size); // p1과 p2의 루트 노드가 같아지도록 --> 같은 집합에 속하도록

                int rootNode = findParent(parents, map.get(p1)); // p1이 속한 집합의 루트 노드를 찾음, p2도 같은 루트노드이니 하나만 함

                bw.write(size[rootNode]+"\n");
            }

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int findParent(int[] parents, int x){

        if(x!=parents[x])
            parents[x] =  findParent(parents, parents[x]);
        return parents[x];

    }

    static void unionParent(int[] parents, int n1, int n2, int[] size){

        int n1Root = findParent(parents, n1);
        int n2Root = findParent(parents, n2);

        if(n1Root< n2Root) { // n2의 루트 노드를 n1Root로 변경
            parents[n2Root] = n1Root;
            size[n1Root] += size[n2Root];

        }
        else if(n1Root>n2Root){ // n1Root를 n2Root로 변경
            parents[n1Root] = n2Root;
            size[n2Root] +=size[n1Root];

        }

    }

}
