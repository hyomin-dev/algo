package com.multi.baekjoon.tmp;


import java.io.*;
import java.util.StringTokenizer;

public class P_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1Up = Integer.parseInt(st.nextToken());
        int n1Down = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int n2Up = Integer.parseInt(st.nextToken());
        int n2Down = Integer.parseInt(st.nextToken());


        int nUp = n1Up*n2Down + n2Up*n1Down;
        int nDown = n1Down*n2Down;

        if(nUp==nDown)
            bw.write("1 1");
        else{
            int gcd = euclidean(Math.max(nUp,nDown),Math.min(nUp,nDown));

            bw.write(nUp/gcd+" "+nDown/gcd);
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int euclidean(int a, int b){
        if(b==0)
            return a;
        return euclidean(b, a%b); // 나누는 수, r
    }
}
