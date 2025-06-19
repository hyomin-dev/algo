package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] intArray = new Integer[30];
        for(int i=1;i<=30;i++)
            intArray[i-1] = i;

        List<Integer> rollBook = new ArrayList<>(Arrays.asList(intArray));

        int count=0;
        while(count<28){
            Integer num = Integer.parseInt(br.readLine());
            rollBook.remove(num);
            count++;
        }

        bw.write(String.valueOf(rollBook.get(0)));
        bw.newLine();
        bw.write(String.valueOf(rollBook.get(1)));
        bw.flush();
        bw.close();
        br.close();

    }
}
