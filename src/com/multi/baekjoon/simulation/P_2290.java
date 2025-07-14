package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_2290 {
    static int s;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken()); // 1 <= s <= 10, 크기

        String nStr = st.nextToken();
        long n = Long.parseLong(nStr); // 0 <= n <= 9,999,999,999, LCD 모니터에 나타내야할 수
        for(int h=1;h<=2*s+3;h++){
            for(int d=0;d<nStr.length();d++){
                int digitNum = nStr.charAt(d) - '0';
                switch(digitNum){
                    case 0:{
                        zero(h);
                        break;
                    }
                    case 1:{
                        one(h);
                        break;
                    }
                    case 2:{
                        two(h);
                        break;
                    }
                    case 3:{
                        three(h);
                        break;
                    }
                    case 4:{
                        four(h);
                        break;
                    }
                    case 5:{
                        five(h);
                        break;
                    }
                    case 6:{
                        six(h);
                        break;
                    }
                    case 7:{
                        seven(h);
                        break;
                    }
                    case 8:{
                        eight(h);
                        break;
                    }
                    case 9:{
                        nine(h);
                        break;
                    }
                }
                if(d!=nStr.length()-1)
                    bw.write(" ");
            }
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();

    }
    static void zero(int h) throws IOException{
        if(h==1||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else if(h==s+2){
            bw.write("  ");
            for(int i=0;i<s;i++)
                bw.write(" ");
        }else{
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void one(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write("  ");
            for(int i=0;i<s;i++)
                bw.write(" ");
        }else{
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }

    }
    static void two(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else if(1<h&&h<s+2){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }else if(s+2<h&&h<2*s+3){
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write(" ");
        }

    }
    static void three(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else{
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void four(int h) throws IOException{
        if(h==1||h==2*s+3){
            bw.write("  ");
            for(int i=0;i<s;i++)
                bw.write(" ");
        }else if(1<h&&h<s+2){
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }else if (h==s+2){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }
        else{
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void five(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else if(1<h&&h<s+2){
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write(" ");
        }else{
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void six(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else if(1<h&&h<s+2){
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write(" ");
        }else{
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void seven(int h) throws IOException{
        if(h==1){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else if(h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write(" ");
        }else{
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void eight(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else{
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
    static void nine(int h) throws IOException{
        if(h==1||h==s+2||h==2*s+3){
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write("-");
            bw.write(" ");
        }else if(1<h&&h<s+2){
            bw.write("|");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }else{
            bw.write(" ");
            for(int i=0;i<s;i++)
                bw.write(" ");
            bw.write("|");
        }
    }
}
