package com.multi.baekjoon._1DArray;


import java.io.*;
import java.util.Arrays;

public class P_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i=0;
        Integer[] intArray = new Integer[9];
        while(i<9){
            intArray[i] = Integer.parseInt(br.readLine());
            i++;
        }

        Integer[] copyIntArray = intArray.clone();

        Arrays.sort(copyIntArray);

        Integer maxNum = copyIntArray[8];
        bw.write(String.valueOf(maxNum));
        bw.newLine();
        for(int j=0;j<9;j++){
            if(maxNum.equals(intArray[j])){
                bw.write(String.valueOf(j+1));
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
