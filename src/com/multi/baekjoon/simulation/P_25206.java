package com.multi.baekjoon.simulation;


import java.io.*;
import java.util.StringTokenizer;

public class P_25206 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        double sumScoreWithSubMean = 0;
        double sumScore = 0;

        for(int i=0;i<20;i++){
            StringTokenizer str = new StringTokenizer(br.readLine());
            String subject = str.nextToken();
            double score = Double.parseDouble(str.nextToken());
            String grade = str.nextToken();

            if(grade.equals("P"))
                continue;
            else if(grade.equals("A+")){
                sumScoreWithSubMean += score*4.5;
            }else if(grade.equals("A0")){
                sumScoreWithSubMean += score*4.0;
            }else if(grade.equals("B+")){
                sumScoreWithSubMean += score*3.5;
            }else if(grade.equals("B0")){
                sumScoreWithSubMean += score*3.0;
            }else if(grade.equals("C+")){
                sumScoreWithSubMean += score*2.5;
            }else if(grade.equals("C0")){
                sumScoreWithSubMean += score*2.0;
            }else if(grade.equals("D+")){
                sumScoreWithSubMean += score*1.5;
            }else if(grade.equals("D0")){
                sumScoreWithSubMean += score*1.0;
            }else if(grade.equals("F")){
                sumScoreWithSubMean +=score*0.0;
            }
            sumScore += score;

        }

        double result = sumScoreWithSubMean / sumScore;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();

    }
}
