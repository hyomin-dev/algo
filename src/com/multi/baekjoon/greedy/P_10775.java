package com.multi.baekjoon.greedy;

import java.io.*;
import java.util.*;

public class P_10775 {
    static int g, p;
    static int[] parents, planes;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        g = Integer.parseInt(br.readLine()); // 게이트의 수
        p = Integer.parseInt(br.readLine()); // 비행기의 수

        parents = new int[g+1];
        planes = new int[p+1];

        for(int i=1;i<=p;i++)
            planes[i] = Integer.parseInt(br.readLine());

        for(int i=0;i<=g;i++)
            parents[i] = i;

        int count = 0;
        for(int i=1;i<=p;i++){
            int gi = planes[i];
            int root = findParent(gi);
            if(root==0) // 더 이상 도킹할 공간이 없다는 의미
                break;
            else{
                unionParent(root-1,gi); // root와 gi를 union
                count++;
            }

        }

        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();

    }

    static int findParent(int x){
        if(x!=parents[x])
            parents[x] = findParent(parents[x]);
        return parents[x];
    }

    static void unionParent(int a, int b){
        int aRoot = findParent(a);
        int bRoot = findParent(b);

        if(aRoot<bRoot)
            parents[bRoot] = aRoot;
        else
            parents[aRoot] = bRoot;

    }
}

/*

i번째 비행기를 가장 번호가 높은 곳에 도킹 --> i+1번째 비행기도 가장 번호가 높은 곳에 도킹 --> 도킹이 불가능하면 그만

union-find:

초기에는 자기 자신을 부모로 설정
자기 자신에 도킹을 하면 자신보다 번호가 1 작은 곳과 union연산 --> 자신보다 번호가 1작은 곳이 가리키는 곳에 도킹을 하라는 의미

만약 0을 가리킨다면 도킹이 불가능한 곳 --> 도킹 작업 중단

어떤 수 x의 rootNode의미: x번게이트까지 도킹할 수 있는 비행기가 있다. 이 비행기는 현재 rootNode에 도킹할 수 있다는 의미



* */
