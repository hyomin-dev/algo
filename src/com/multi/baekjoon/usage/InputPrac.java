package com.multi.baekjoon.usage;



import java.io.*;
import java.util.StringTokenizer;

public class InputPrac {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println("==================");
        String str;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            StringTokenizer st = new StringTokenizer(str);
            while (st.hasMoreTokens()) {
                bw.write(st.nextToken());
                bw.write("\n");
            }
        }

        //bw.flush();
        //bw.newLine();
        bw.close();
        br.close();

    }
}
