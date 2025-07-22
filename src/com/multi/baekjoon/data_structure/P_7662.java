package com.multi.baekjoon.data_structure;


/*
I: q에 데이터 삽입
D 1: q에서 최댓값 삭제
D -1: q에서 최솟값 삭제

1. 시도: 시간 초과
우선 순위 큐에서 꺼낸다 → -1을 곱한다. → 최댓값 꺼낸다 → -1을 곱한다. → 우선 순위 큐에 넣는다.

2. 시도: 시간 초과
리스트에 담을 때마다 정렬

3. 시도: 시간 초과
이진 트리에 담기

 * */
import java.io.*;
import java.util.*;

public class P_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t > 0) {

            int k = Integer.parseInt(br.readLine()); // Q에 적용할 연산의 개수, k <= 1,000,000

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);

                } else if (num == 1 && !treeMap.isEmpty()) { // 최대값 삭제
                    Map.Entry<Integer, Integer> entry = treeMap.lastEntry();
                    int key = entry.getKey();
                    int value = entry.getValue();
                    if (value == 1) {
                        treeMap.pollLastEntry();
                    } else {
                        treeMap.put(key, treeMap.get(key) - 1); //위에서 이미 확인 했기 때문에 getOrDefault를 안씀
                    }


                } else if (num == -1 && !treeMap.isEmpty()) {
                    Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
                    int key = entry.getKey();
                    int value = entry.getValue();
                    if (value == 1) {
                        treeMap.pollFirstEntry();
                    } else {
                        treeMap.put(key, treeMap.get(key) - 1); //위에서 이미 확인 했기 때문에 getOrDefault를 안씀
                    }
                }
            }

            if (!treeMap.isEmpty()) {

                Map.Entry<Integer, Integer> entry = treeMap.firstEntry();
                int minValue = entry.getKey();

                entry = treeMap.lastEntry();
                int maxValue = entry.getKey();

                bw.write(maxValue + " " + minValue + "\n");

            } else
                bw.write("EMPTY\n");

            t--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

