package com.multi.baekjoon.graph;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class P_14226 {
    static int s;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        s = Integer.parseInt(br.readLine()); // 2 <= s <= 1000

        visited = new boolean[10000][10000]; // 화면 이모티콘 x 클립보드 이모티콘

        visited[1][0] = true;
        int result = bfs(new int[]{1,0,0}); // 화면 이모티콘 개수, 클립보드 이모티콘 개수, 시간

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int[] start){
        Queue<int[]> q = new LinkedList<>();

        q.offer(start);

        while(!q.isEmpty()){
            int[] x = q.poll();

            int numScreen = x[0];
            int numClipBoard = x[1];
            int time = x[2];

            if(numScreen==s){
                return time;
            }

            // 1번 연산
            if(numScreen!=numClipBoard) { // 화면 이모티콘 개수와 클립보드 개수가 다를 때만, 화면 이모티콘을 클립보드에 복사
                q.offer(new int[]{numScreen, numScreen, time + 1});
            }

            // 2번 연산
            if(!visited[numScreen+numClipBoard][numClipBoard]&&numClipBoard!=0) { // 클립보드에 있는 이모티콘을 화면에 붙였을 때, 이모티콘 개수를 화면에 나타낸 적이 없는 경우에만
                q.offer(new int[]{numScreen + numClipBoard, numClipBoard, time + 1});
                visited[numScreen+numClipBoard][numClipBoard] = true;
            }

            // 3번 연산

            if(!visited[numScreen-1][numClipBoard]&&numScreen-1!=0) { // 화면에 있는 이모티콘 -1을 화면에 나타낸 적이 없는 경우에만
                q.offer(new int[]{numScreen - 1, numClipBoard, time + 1});
                visited[numScreen-1][numClipBoard] = true;
            }

        }

        return -1;
    }
}

/*
1번 연산: 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장 --> 이전에 클립보드에 있던 내용은 덮어쓰기 됨

2번 연산: 클립보드에 있는 모든 이모티콘을 화면에 붙여 넣기
--> 클립보드에 아무것도 없으면 붙여 넣기 안됨, 클립보드의 일부만 붙여 넣기 안됨, 클립보드에 있는 이모티콘 중 일부를 삭제 할 수 없음
--> 붙여 넣기하면, 화면에 있는 이모티콘에 추가가 되는 것임(덮어쓰기 아님)

3번 연산: 화면에 있는 이모티콘 중 하나를 삭제

모든 연산은 1초 소요


* */
