package com.multi.baekjoon.shortest_path;

import java.io.*;
import java.util.*;

public class P_11779 {

    static int n, m, start, dest;
    static ArrayList<ArrayList<Node11779>> graph = new ArrayList<>();
    static int[] distArray;
    static int[] prev;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distArray = new int[n+1];
        Arrays.fill(distArray, INF);

        prev = new int[n+1];
        for(int i=1;i<=n;i++)
            prev[i] = i; // 이전 노드를 자기자신으로 초기화

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        while(m>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()); // 출발
            int e = Integer.parseInt(st.nextToken()); // 도착
            int c = Integer.parseInt(st.nextToken()); // 비용

            graph.get(s).add(new Node11779(e,c));

            m--;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        dijkstra(start);

        ArrayList<Integer> record = new ArrayList<>(); // 도착 노드부터 출발 노드까지 담을 리스트

        for(int cur=dest;cur!=start;cur = prev[cur]){ // 도착 노드 부터 출발 노드 전까지 담음
            record.add(cur);
        }
        record.add(start);

        bw.write(distArray[dest]+"\n");

        bw.write(record.size()+"\n");
        for(int i=record.size()-1;i>=0;i--)
            bw.write(record.get(i)+" ");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node11779> pq = new PriorityQueue<>();

        pq.offer(new Node11779(start, 0));
        distArray[start] = 0;

        while(!pq.isEmpty()){
            Node11779 now = pq.poll();

            int nowIndex = now.getIndex();
            int nowCost = now.getCost();

            if(distArray[nowIndex]<nowCost)
                continue;

            for(int i=0;i<graph.get(nowIndex).size();i++){
                Node11779 adjcency = graph.get(nowIndex).get(i);
                int cost = nowCost + adjcency.getCost();

                if(distArray[adjcency.getIndex()]>cost){
                    distArray[adjcency.getIndex()] = cost;
                    prev[adjcency.getIndex()] = nowIndex; // 이전 노드를 저장

                    pq.offer(new Node11779(adjcency.getIndex(),cost));
                }

            }
        }

    }
}

class Node11779 implements Comparable<Node11779>{
    private int index;
    private int cost;

    public Node11779(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    public int getIndex(){
        return this.index;
    }

    public int getCost(){
        return this.cost;
    }

    @Override
    public int compareTo(Node11779 o){
        return this.cost - o.cost;
    }
}
