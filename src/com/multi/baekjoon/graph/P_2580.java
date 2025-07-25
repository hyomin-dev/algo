package com.multi.baekjoon.graph;

import java.io.*;
import java.util.*;

public class P_2580 {
    static int n = 9;
    static int[][] graph = new int[10][10];
    static int zeroCount = 0;
    static boolean isFind = false;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<int[]> blankList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        for (int y = 1; y <= 9; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= 9; x++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 0) {
                    zeroCount += 1;
                    blankList.add(new int[]{x, y});
                }
                graph[y][x] = num;
            }
        }

        search(0);

        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int count) throws IOException {
        if (count == zeroCount) {

            for (int y = 1; y <= n; y++) {
                for (int x = 1; x <= n; x++)
                    bw.write(graph[y][x] + " ");
                bw.newLine();
            }
            isFind = true;
            return;
        }

        int[] node = blankList.get(count);
        for (int num = 1; num <= 9; num++) {
            if (!isFind && graph[node[1]][node[0]] == 0) {
                // 가로 체크
                if (!checkRow(node[1], num))
                    continue;

                // 세로 체크
                if (!checkCol(node[0], num))
                    continue;

                // 3x3체크
                if (!checkSquare(node[0], node[1], num))
                    continue;

                graph[node[1]][node[0]] = num;
                count++;
                search(count);
                count--;
                graph[node[1]][node[0]] = 0;
            }
        }

    }

    static boolean checkRow(int y, int num) {

        for (int x = 1; x <= n; x++)
            if (graph[y][x] == num)
                return false;

        return true;
    }

    static boolean checkCol(int x, int num) {

        for (int y = 1; y <= n; y++)
            if (graph[y][x] == num)
                return false;

        return true;
    }

    static boolean checkSquare(int x, int y, int num) {
        int startX, startY;

        if (x <= 3)
            startX = 1;
        else if (x <= 6)
            startX = 4;
        else
            startX = 7;

        if (y <= 3)
            startY = 1;
        else if (y <= 6)
            startY = 4;
        else
            startY = 7;


        for (int i = startY; i < startY + 3; i++) {
            for (int j = startX; j < startX + 3; j++) {
                if (graph[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}

