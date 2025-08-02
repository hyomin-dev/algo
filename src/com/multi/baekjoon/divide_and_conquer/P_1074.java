package com.multi.baekjoon.divide_and_conquer;

import java.io.*;
import java.util.*;

public class P_1074 {
    static int r, c;
    static long order = 0;
    static boolean isFind = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        search(n, 0, 0);

        bw.write(order + "");

        bw.flush();
        bw.close();
        br.close();

    }

    static void search(int n, long row, long col) {

        if (n == 1) {
            if (isFind)
                return;
            for (long rr = row; rr <= row + 1; rr++) {
                for (long cc = col; cc <= col + 1; cc++) {
                    if (cc == c && rr == r) {
                        isFind = true;
                        return;
                    } else
                        order++;
                }
            }
        } else {

            long powNMinus = (long) Math.pow(2, n - 1);
            // 왼쪽 위
            if (!isFind && row <= r && r < row + powNMinus && col <= c && c < col + powNMinus) // 왼쪽 위
                search(n - 1, row, col);
            else if (!isFind)
                order += powNMinus * powNMinus;

            if (!isFind && row <= r && r < row + powNMinus && col + powNMinus <= c && c < col + 2 * powNMinus) // 오른쪽 위
                search(n - 1, row, col + powNMinus);
            else if (!isFind)
                order += powNMinus * powNMinus;

            if (!isFind && row + powNMinus <= r && r < row + 2 * powNMinus && col <= c && c < col + powNMinus) //왼쪽 아래
                search(n - 1, row + powNMinus, col);
            else if (!isFind)
                order += powNMinus * powNMinus;

            if (!isFind)
                search(n - 1, row + powNMinus, col + powNMinus);
            else if (!isFind)
                order += powNMinus * powNMinus;

        }
    }
}
