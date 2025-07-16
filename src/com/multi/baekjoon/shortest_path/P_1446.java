package com.multi.baekjoon.shortest_path;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1446 {
    static ArrayList<ArrayList<Node1446>> graph = new ArrayList<>();
    static int n,d;
    static int[] distArray;

    public static void main(String[] args) throws IOException {

        final int INF = (int)1e9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        distArray = new int[d+1];

        Arrays.fill(distArray,INF);

        for(int i=0;i<=d;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if(node2>d)
                continue;
            graph.get(node1).add(new Node1446(node2,length));
        }

        for(int i=0;i<d;i++){
            graph.get(i).add(new Node1446(i+1,1)); // 지름길이 없이 고속도로를 탈 경우를 고려
        }

        dijkstra(0);

        bw.write(String.valueOf(distArray[d]));
        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node1446> pq = new PriorityQueue<>();
        pq.offer(new Node1446(start,0));
        distArray[start] = 0;

        while(!pq.isEmpty()){
            Node1446 node = pq.poll();

            int now = node.getIndex();
            int distance = node.getDistance();

            if(distArray[now]<distance) // now로가는 최단 경로가 이미 구해진 경우
                continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost = distArray[now] +graph.get(now).get(i).getDistance();
                if(cost<distArray[graph.get(now).get(i).getIndex()]){
                    distArray[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node1446(graph.get(now).get(i).getIndex(),cost));
                }
            }
        }
    }
}

class Node1446 implements Comparable<Node1446>{
    int index;
    int distance;

    public Node1446(int index, int distance){
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
    public int compareTo(Node1446 o){
        // 오름 차순
        if(this.distance!=o.distance)
            return this.distance - o.distance;

        return 0;
    }
}
