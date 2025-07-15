package com.multi.baekjoon.shortest_path;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node1753 implements Comparable<Node1753>{
    int index;
    int distance;

    public Node1753(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    int getIndex(){
        return this.index;
    }

    int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node1753 o){
        if(this.distance!=o.distance)
            return this.distance - o.distance;

        return 0;
    }

}
public class P_1753 {

    static int v,e,k;
    static ArrayList<ArrayList<Node1753>> graph = new ArrayList<>();
    static int[] d;

    public static void main(String[] args) throws IOException {

        final int INF = (int)1e9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수
        k = Integer.parseInt(br.readLine()); // 시작 정점

        d = new int[v+1];
        Arrays.fill(d,INF);

        for(int i=0;i<=v;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node1753(v,w));
        }

        dijkstra(k);

        for(int i=1;i<=v;i++){
            if(i==k)
                bw.write(String.valueOf(d[k]));
            else if(d[i]==INF)
                bw.write("INF");
            else
                bw.write(String.valueOf(d[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node1753> pq = new PriorityQueue<>();
        pq.offer(new Node1753(start,0));
        d[start] = 0;

        while(!pq.isEmpty()){

            Node1753 node = pq.poll();

            int now = node.getIndex();
            int distance = node.getDistance();

            if(d[now] <distance) // 다른 곳에서 now node까지 최단 경로를 발견한 경우
                continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if(d[graph.get(now).get(i).getIndex()]>cost){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node1753(graph.get(now).get(i).getIndex(),cost));
                }
            }
        }

    }

}
