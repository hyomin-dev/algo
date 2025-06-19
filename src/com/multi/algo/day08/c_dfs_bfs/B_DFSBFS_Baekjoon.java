package com.multi.algo.day08.c_dfs_bfs;


import java.io.*;
import java.util.*;

public class B_DFSBFS_Baekjoon {
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    static StringBuilder dfsResult = new StringBuilder();
    static StringBuilder bfsResult = new StringBuilder();
    public static void main(String[] args) throws IOException {
        List<String> testCases = Arrays.asList(
                "4 5 1\n1 2\n1 3\n1 4\n2 4\n3 4",
                "5 5 3\n5 4\n5 2\n1 2\n3 4\n3 1",
                "1000 1 1000\n999 1000"
        );

        for (String data : testCases) {
            InputStream is = new ByteArrayInputStream(data.getBytes());
            System.setIn(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());  // 정점의 수
            int M = Integer.parseInt(st.nextToken());  // 간선의 수
            int Start = Integer.parseInt(st.nextToken());  // 시작 정점

            adjList = new ArrayList[N + 1]; // 인덱스 +1
            for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adjList[s].add(e);
                adjList[e].add(s);  // 양방향 간선 추가
            }

            System.out.println(Arrays.toString(adjList));


            // DFS
            visited = new boolean[N + 1];
            DFS(Start);
            // BFS
            visited = new boolean[N + 1];
            BFS(Start);


            System.out.println("DFS Result: " + dfsResult.toString().trim());
            System.out.println("BFS Result: " + bfsResult.toString().trim());
            dfsResult.setLength(0);
            bfsResult.setLength(0);

        }
    }


    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start); // 시작 노드 추가
        visited[start] = true; // 방문했으면 true 로 변경

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsResult.append(node).append(" ");
            for (int neighbor : adjList[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    private static void DFS(int node) {

        visited[node] = true;
        dfsResult.append(node).append(" ");

        for(int neighbor: adjList[node]) {
            if(!visited[neighbor]){
                DFS(neighbor);
            }
        }

    }
}
