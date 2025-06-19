package com.multi.code_plus.math;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem_10430 {

    public static void main(String[] args) throws Exception {
        solution();
    }

    public static void solution() throws Exception{
        // 입력: "5 8 4"
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer s = new StringTokenizer(br.readLine());
        int A=0, B=0, C = 0;


       bw.write("s.countTokens() = " + s.countTokens()); // 출력: 3
        bw.newLine();

       bw.write("s.hasMoreTokens() = " + s.hasMoreTokens()); // 출력: true
        bw.newLine();

        if(s.hasMoreTokens())
            A = Integer.parseInt(s.nextToken()); //5를 가져옴
        if(s.hasMoreTokens())
            B = Integer.parseInt(s.nextToken()); // 8을 가져옴
        if(s.hasMoreTokens())
            C = Integer.parseInt(s.nextToken()); // 4를 가져옴

        bw.write("s.hasMoreTokens() = " + s.hasMoreTokens()); // 출력: false
        bw.newLine();

        bw.write( (A+B)%C+"");
        bw.newLine();

        bw.write(((A%C)+(B%C))%C+"");
        bw.newLine();

        bw.write((A*B)%C+"");
        bw.newLine();

        bw.write(((A%C)*(B%C)%C+""));
        bw.newLine();

        //bw.flush();

        bw.close();
        br.close();

    }
}
