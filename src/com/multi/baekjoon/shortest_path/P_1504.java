package com.multi.baekjoon.shortest_path;

import java.io.*;
import java.util.*;

public class P_1504 {

    static ArrayList<ArrayList<Node1504>> graph = new ArrayList<>();
    static int n,e,v1,v2;
    static int[] distArray;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        distArray = new int[n+1];
        Arrays.fill(distArray, INF);

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node1504(b,c));
            graph.get(b).add(new Node1504(a,c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        distArray[1] = 0;
        dijkstra(1); // 1~n까지 최단 거리 구함

        if(v1==1&&v2==n){  //v1==1, v2==n인 경우 --> 1 -> n
            if(distArray[n]==INF)
                bw.write("-1");
            else
                bw.write(distArray[n]+"");
        }else if(v1!=1&&v2==n){ //v1!=1, v2==n인 경우 --> 1 -> v1 -> n
            int oneToV1 = distArray[v1];
            Arrays.fill(distArray,INF);
            distArray[v1] = oneToV1;
            dijkstra(v1);

            if(distArray[n]==INF)
                bw.write("-1");
            else
                bw.write(distArray[n]+"");
        }else if(v1==1&&v2!=n){  //v1==1, v2!=n인 경우 --> 1 -> v2 -> n
            int oneToV2 = distArray[v2];
            Arrays.fill(distArray,INF);
            distArray[v2] = oneToV2;
            dijkstra(v2);

            if(distArray[n]==INF)
                bw.write("-1");
            else
                bw.write(distArray[n]+"");
        }else {
            // 1 -> v1 -> v2 -> n과 1 -> v2 -> v1 -> n를 둘 다 해봄

            int oneToV1 = distArray[v1];
            int oneToV2 = distArray[v2];

            // 1 -> v1 -> v2 -> n
            Arrays.fill(distArray,INF);
            distArray[v1] = oneToV1;
            dijkstra(v1);

            int v1ToV2 = distArray[v2];
            Arrays.fill(distArray,INF);
            distArray[v2] = v1ToV2;
            dijkstra(v2);

            int oneToV1ToV2ToN = distArray[n];

            // 1 -> v2 -> v1 -> n
            Arrays.fill(distArray,INF);
            distArray[v2] = oneToV2;
            dijkstra(v2);

            int v2ToV1 = distArray[v1];
            Arrays.fill(distArray,INF);
            distArray[v1] = v2ToV1;
            dijkstra(v1);

            int oneToV2ToV1ToN = distArray[n];

            if(oneToV1ToV2ToN ==INF&&oneToV2ToV1ToN==INF)
                bw.write("-1");
            else if(oneToV1ToV2ToN<=oneToV2ToV1ToN)
                bw.write(oneToV1ToV2ToN+"");
            else if(oneToV1ToV2ToN>oneToV2ToV1ToN)
                bw.write(oneToV2ToV1ToN+"");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node1504> pq = new PriorityQueue<>();
        pq.offer(new Node1504(start, distArray[start]));

        while (!pq.isEmpty()) {
            Node1504 node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDist();

            if(distArray[now]<dist)
                continue;

            for(int i=0;i<graph.get(now).size();i++){
                int cost = distArray[now] + graph.get(now).get(i).getDist();

                if(cost<distArray[graph.get(now).get(i).getIndex()]){
                    distArray[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node1504(graph.get(now).get(i).getIndex(),cost));
                }

            }
        }

    }
}

class Node1504 implements Comparable<Node1504>{

    private int index;
    private int dist;

    public Node1504(int index, int dist){
        this.index = index;
        this.dist = dist;
    }

    int getIndex(){
        return this.index;
    }

    int getDist(){
        return this.dist;
    }

    @Override
    public int compareTo(Node1504 o){
        return this.dist - o.getDist();
    }
}
