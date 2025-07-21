import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[500+1];

        array[0] = 0;
        array[1] = 0;
        array[2] = 0;
        array[3] = 0;
        array[4] = 0;

        int zeroNum = 1;
        int start = 1;
        int end = 2;

        while(end*5-1<=499){
            for(int i=start*5;i<=5*end-1;i++){
                array[i] = zeroNum;
            }

            start++;
            end++;
            int count = 0;

            int num = 5*start;
            while(true){

                int q = num/5;
                if(q%5==0){
                    num = q;
                    count++;
                }else{
                    count++;
                    break;
                }
            }

            zeroNum +=count;
        }

        // 500 = 5*5*5*4
        array[500] = zeroNum;

        bw.write(array[n]+"");

        bw.flush();
        bw.close();
        br.close();

    }
}

/*
2!부터 N!는 모두 짝수

짝수에 5를 곱하면 0이 생김


* */
