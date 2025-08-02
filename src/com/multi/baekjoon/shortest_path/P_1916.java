package com.multi.baekjoon.shortest_path;

import java.io.*;
import java.util.*;

public class P_1916 {

    static int n,m;
    static ArrayList<ArrayList<Node1916>> graph = new ArrayList<>();
    static int[] distArray;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        distArray = new int[n+1];
        Arrays.fill(distArray, INF);

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        while(m>0){

            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node1916(dest, cost));

            m--;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        dijkstra(start);

        bw.write(distArray[dest]+"");
        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node1916> pq = new PriorityQueue<>();
        pq.offer(new Node1916(start,0));
        distArray[start] = 0;

        while(!pq.isEmpty()){

            Node1916 now = pq.poll();

            int index = now.getIndex();
            int dist = now.getDist();

            if(distArray[index]<dist)
                continue;

            for(int i=0;i<graph.get(index).size();i++){
                int adjcencyIndex = graph.get(index).get(i).getIndex();
                int cost = distArray[index] + graph.get(index).get(i).getDist();
                if(cost<distArray[adjcencyIndex]){
                    distArray[adjcencyIndex] = cost;
                    pq.offer(new Node1916(adjcencyIndex,cost));
                }
            }

        }
    }
}

class Node1916 implements Comparable<Node1916>{

    private int index;
    private int dist;

    public Node1916(int index, int dist){
        this.index = index;
        this.dist = dist;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDist(){
        return this.dist;
    }

    @Override
    public int compareTo(Node1916 o){
        return this.dist - o.getDist();
    }
}
