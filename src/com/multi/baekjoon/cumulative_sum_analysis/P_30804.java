package com.multi.baekjoon.cumulative_sum_analysis;

import java.io.*;
import java.util.*;

public class P_30804 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        int[] fruit = new int[11];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;
        Set<Integer> set = new HashSet<>();
        int maxLength = 0; // 투 포인터를 이동하면서 구한 최대 과일의 개수

        for(int start=0;start<n;start++){

            while(set.size()<=2&&end<n){ //end를 오른쪽으로 이동할 경우: 과일의 개수가 늘어남 and 과일의 종류가 늘어날 수 있음
                set.add(array[end]);
                fruit[array[end]]+=1;

                // 현재 과일의 개수
                int length = end-start +1;

                if(set.size()<=2&&length>maxLength) // end가 가리키는 과일을 추가할 때 마다 현재 과일의 개수를 카운트함
                    maxLength = length;
                end++;
            }

            // 과일의 종류가 2 이상이면 left pointer를 오른쪽으로 이동 --> 과일을 줄인다는 의미
            if(fruit[array[start]]>=2){
                fruit[array[start]] -=1;

            }else { // 1개 인 경우, 해당 과일 set에서 제거
                fruit[array[start]] -=1;
                set.remove(array[start]);
            }
        }

        bw.write(maxLength+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
