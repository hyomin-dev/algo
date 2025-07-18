package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_14215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int s3 = Integer.parseInt(st.nextToken());

        if(s1==s2&&s2==s3) {
            bw.write(String.valueOf(s1 + s2 + s3));

        }else {

            int[] array = new int[]{s1, s2, s3};
            Arrays.sort(array);
            if (array[0] + array[1] > array[2])
                bw.write(String.valueOf(s1 + s2 + s3));
            else
                bw.write(String.valueOf(2 * array[0] + 2 * array[1] - 1)); // 가장 긴 변의 길이를 나머지 두변의 길이의 합 -1로 바꿔야 하기 때문
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
