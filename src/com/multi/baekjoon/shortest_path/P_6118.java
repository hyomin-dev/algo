package com.multi.baekjoon.shortest_path;


import java.io.*;
import java.util.*;

public class P_6118 {

    static int n,m;
    static ArrayList<ArrayList<Node6118>> graph = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<Integer> longestShed = new ArrayList<>();
    static int longestLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        while(m>0){

            st = new StringTokenizer(br.readLine());

            int a_i = Integer.parseInt(st.nextToken());
            int b_i = Integer.parseInt(st.nextToken());

            graph.get(a_i).add(new Node6118(b_i,1));
            graph.get(b_i).add(new Node6118(a_i,1));

            m--;
        }

        bfs(1);

        Collections.sort(longestShed);

        bw.write(longestShed.get(0)+" "+longestLength+" "+longestShed.size());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        Queue<Node6118> q = new LinkedList<>();

        q.offer(new Node6118(start, 0));
        visited[start] = true;

        while(!q.isEmpty()){
            Node6118 node = q.poll();

            int now = node.getIndex();
            int distance = node.getDistance();

            if(longestLength<distance){
                longestShed = new ArrayList<>();
                longestShed.add(now);
                longestLength = distance;
            } else if(longestLength==distance){
                longestShed.add(now);
            }

            for(int i=0;i<graph.get(now).size();i++) {
                Node6118 adjcencyNode = graph.get(now).get(i);
                if(!visited[adjcencyNode.getIndex()]){
                    q.offer(new Node6118(adjcencyNode.getIndex(),distance+ adjcencyNode.getDistance()));
                    visited[adjcencyNode.getIndex()] = true;
                }
            }
        }

    }
}

class Node6118{
    private int index;
    private int distance;

    public Node6118(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    int getIndex(){
        return this.index;
    }

    int getDistance(){
        return this.distance;
    }

}

/*

헛간: 숨을 수 있는 공간

헛간의 개수: n, 2 <= n <= 20000

길의 개수: m, 1 <= m <= 50000

헛간에서 헛간은 이동 가능
* */