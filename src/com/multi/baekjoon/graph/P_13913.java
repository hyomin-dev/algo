package com.multi.baekjoon.graph;


import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_13913 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] visited = new boolean[100001];
    static int[] parent = new int[100001];
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        bw.flush();
        bw.close();
        br.close();

    }

    static void bfs(int node) throws IOException{

        Queue<int[]> q = new LinkedList();


        q.offer(new int[]{node,0}); // 현재 노드, 현재 노드까지 걸린 시간
        visited[node] = true;
        parent[node] = node; // parent[node] == node인 경우 stop, 부모와 자식이 같은 경우

        while(!q.isEmpty()){

            // 주변 노드 탐색
            int[] currArray = q.poll();
            int currNode = currArray[0];
            int currTime = currArray[1];

            if(currNode ==k){
                bw.write(String.valueOf(currTime));
                bw.newLine();
                ArrayList<Integer> list = new ArrayList<>();

                int copyCurrNode = currNode;
                list.add(currNode);
                while(true){

                    if(parent[copyCurrNode]==copyCurrNode)
                        break;
                    else{
                        list.add(parent[copyCurrNode]);
                        copyCurrNode = parent[copyCurrNode];
                    }
                }

                for(int i=list.size()-1;i>=0;i--)
                    bw.write(list.get(i)+" ");
            }

            // 방문 처리
            // node-1
            if(currNode-1>=0&&!visited[currNode-1]){

                q.offer(new int[]{currNode-1,currTime+1});
                visited[currNode-1] = true;
                parent[currNode-1] = currNode;
            }

            // node+1
            if(currNode+1<=100000&&!visited[currNode+1]){

                q.offer(new int[]{currNode+1, currTime+1});
                visited[currNode+1] = true;
                parent[currNode+1] = currNode;
            }

            // node*2
            if(currNode*2<=100000&&!visited[currNode*2]){

                q.offer(new int[]{currNode*2, currTime+1});
                visited[currNode*2] = true;
                parent[currNode*2] = currNode;
            }

        }
    }
}
