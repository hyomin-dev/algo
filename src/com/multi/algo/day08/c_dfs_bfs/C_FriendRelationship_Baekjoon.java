package com.multi.algo.day08.c_dfs_bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/13023
public class C_FriendRelationship_Baekjoon {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        List<String> testCases = new ArrayList<>();
        testCases.add("5 4\n0 1\n1 2\n2 3\n3 4");
        testCases.add("5 5\n0 1\n1 2\n2 3\n3 0\n1 4");
        testCases.add("6 5\n0 1\n0 2\n0 3\n0 4\n0 5");
        testCases.add("8 8\n1 7\n3 7\n4 7\n3 4\n4 6\n3 5\n0 4\n2 7");

        for (String data : testCases) {
            InputStream is = new ByteArrayInputStream(data.getBytes());
            System.setIn(is);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            adj = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                adj[s].add(e);
                adj[e].add(s); // 양방향 간선 추가
            }
        }
    }
}
