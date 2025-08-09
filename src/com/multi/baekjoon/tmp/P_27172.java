package com.multi.baekjoon.tmp;

import java.io.*;
import java.util.*;

public class P_27172 {
    static int n;
    static int[] array, scores;
    static boolean[] isInclude;
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        scores = new int[1000000+1];
        isInclude = new boolean[1000000+1]; // 숫자가 나타난 적이 있는지 여부


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            array[i] = Integer.parseInt(st.nextToken());
            isInclude[array[i]] = true;
            if(array[i]>maxValue)
                maxValue = array[i];
        }

        for(int i=1;i<=n;i++){
            for(int j=2;array[i]*j<=maxValue;j++){
                if(isInclude[array[i]*j]) {
                    scores[array[i]] +=1;
                    scores[array[i]*j] -=1;
                }
            }
        }

        for(int i=1;i<=n;i++)
            bw.write(scores[array[i]]+" ");

        bw.flush();
        bw.close();
        br.close();

    }

}
/*
참고한 풀이: https://shiftpsh.com/files/boardgame-soln.pdf

필요한 것: 어떤 수 X가 등장했는지 여부를 저장하는 배열, 어떤 수 X의 점수를 저장하는 배열

어떤 수 X의 배수 Y가 등장한 경우: X의 점수는 +1, Y의 점수는 -1



*
*
* */

