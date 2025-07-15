package com.multi.baekjoon.shortest_path;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node18352 implements Comparable<Node18352>{
    int index;
    int distance;

    public Node18352(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node18352 o){
        // 오름 차순

        if(this.distance!=o.distance)
            return this.distance - o.distance;
        else
            return 0;

    }

}

public class P_18352 {

    static ArrayList<ArrayList<Node18352>> graph = new ArrayList<>();
    static int[] d;
    static final int INF = (int)1e9;
    static int n,m,k,x;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // node 개수
        m = Integer.parseInt(st.nextToken()); // 도로(간선) 개수
        k = Integer.parseInt(st.nextToken()); // 구하고자하는 최단 거리
        x = Integer.parseInt(st.nextToken()); // 출발 도시

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        d = new int[n+1]; // 최단 거리 리스트

        Arrays.fill(d,INF);

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new Node18352(node2,1)); // node1에서 node2로 연결, 거리는 1
        }

        dijkstra(x);

        boolean isK = false;
        for(int i=1;i<=n;i++){
            if(d[i]==k) {
                bw.write(i+"\n");
                if(!isK)
                    isK = true;
            }
        }

        if(!isK)
            bw.write("-1");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start){
        PriorityQueue<Node18352> pq = new PriorityQueue<>();

        pq.offer(new Node18352(start,0));
        d[start] = 0;

        while(!pq.isEmpty()){

            Node18352 node = pq.poll();

            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now]<dist) // 이미 구한 최단 거리가 더 짧기 때문에 우선순위 큐에 넣어 놓은 것은 처리하지 않음
                continue;

            // 주변 노드 탐색
            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(cost <d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node18352(graph.get(now).get(i).getIndex(),cost));
                }
            }

        }

    }
}
