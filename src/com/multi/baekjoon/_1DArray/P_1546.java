package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer num = Integer.parseInt(br.readLine());

        Integer[] intArray = new Integer[num];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i=0;
        while(st.hasMoreTokens()){
            intArray[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intArray);
        Integer maxValue = intArray[num-1];

        double sum=0.0;
        for(i=0;i<num;i++){
            sum+= intArray[i]*100.0/maxValue;
        }

        bw.write(String.valueOf(sum/num));
        bw.flush();
        bw.close();
        br.close();



    }
}
