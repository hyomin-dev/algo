package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_2206 {

    static int n,m;
    static int[][] graph;
    static int minValue = Integer.MAX_VALUE;
    static int[] dx = new int[]{0,0,-1,1}; // 상 하 좌 우
    static int[] dy = new int[]{-1,1,0,0}; // 상 하 좌 우
    static int[][] distGraph;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 <= n <= 1,000
        m = Integer.parseInt(st.nextToken()); // 1 <= m <= 1,000

        graph = new int[n][m];
        distGraph = new int[n][m];

        for(int y=0;y<n;y++)
            Arrays.fill(distGraph[y],INF);

        for(int y=0;y<n;y++){
            String s = br.readLine();
            for(int x=0;x<m;x++){
                graph[y][x] = s.charAt(x) - '0';
            }
        }

        // (1,1)과 (n,m)은 항상 0

        bfs(new int[]{0,0});

        if(minValue==Integer.MAX_VALUE)
            bw.write("-1");
        else
            bw.write(minValue+"");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int[] start){
        PriorityQueue<Node2206> pq = new PriorityQueue<>();
        pq.offer(new Node2206(start[0],start[1],1,false)); // x, y, 방문 깊이, 벽뿌수기 이용 여부(0: 이용안함, 1: 이용함)

        while(!pq.isEmpty()){

            Node2206 node = pq.poll();
            int x = node.getX();
            int y = node.getY();
            int dist = node.getDist();
            boolean isUse = node.getIsUse();

            if(x==m-1&&y==n-1){

                if(dist<minValue)
                    minValue = dist;

                return;
            }

            for(int i=0;i<4;i++){
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if(moveX <0 || moveX>=m || moveY <0 || moveY>=n)
                    continue;

                if(graph[moveY][moveX]==0&&distGraph[moveY][moveX]>=(dist+1)) { // 해당 노드까지 방문하는 것이 더 짧을 경우
                    distGraph[moveY][moveX] = dist+1; // 해당 노드까지 방문하는 거리
                    pq.offer(new Node2206(moveX,moveY,dist+1,isUse));
                }

                else if(graph[moveY][moveX]==1&&!isUse&&distGraph[moveY][moveX]>(dist+1)){ // 벽 뿌수기를 한번도 사용하지 않은 경우, 뼉뿌수기는 거리가 더 짧을 때만
                    distGraph[moveY][moveX] = dist+1;
                    pq.offer(new Node2206(moveX,moveY,dist+1, true));
                }
            }
        }
    }
}

class Node2206 implements Comparable<Node2206>{
    private int x;
    private int y;
    private int dist;
    private boolean isUse;

    public Node2206(int x, int y, int dist, boolean isUse){
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.isUse = isUse;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    int getDist(){
        return this.dist;
    }

    boolean getIsUse(){
        return this.isUse;
    }

    @Override
    public int compareTo(Node2206 o){
        // 거리가 짧은 것 부터
        return this.dist - o.dist;
    }

}