import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] matrix;
    //static ArrayList<Integer> abList = new ArrayList<>();
    //static ArrayList<Integer> cdList = new ArrayList<>();

    static int[] abArray, cdArray;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        matrix = new int[n][4];
        abArray = new int[n*n];
        cdArray = new int[n*n];

        for(int y=0;y<n;y++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int x=0;x<4;x++){
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 0;
        for(int a=0;a<n;a++){
            for(int b=0;b<n;b++){
                abArray[idx++] = matrix[a][0]+matrix[b][1];
            }
        }

        idx = 0;
        for(int c=0;c<n;c++){
            for(int d=0;d<n;d++){
                cdArray[idx++] = matrix[c][2]+matrix[d][3];
            }
        }
        Arrays.sort(abArray);
        Arrays.sort(cdArray);

        long count = 0;
        long prevNum = Integer.MIN_VALUE;
        long prevCount = 0;
        for(int ab: abArray){

            if(ab==prevNum){ // 이전 숫자와 같은 경우
                count+=prevCount;
            }else{
                prevCount = upperBound(-1*ab)-lowerBound(-1*ab);
                count +=prevCount;
                prevNum = ab;
            }

        }

        bw.write(count+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static long lowerBound(int num){
        // num보다 크거나 같은 값이 처음 나타나는 위치

        int start = 0;
        int end = cdArray.length;
        while(start<end){

            int mid = (start+end)/2;
            if(cdArray[mid]<num){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;

    }

    static long upperBound(int num){

        // num보다 큰 값이 처음 나타는 위치

        int start = 0;
        int end = cdArray.length;
        while(start<end){

            int mid = (start+end)/2;
            if(cdArray[mid]<=num){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;

    }

}

/*
A와 B를 더하는 모든 수를 list에 담고 정렬

C와 D를 더하는 모든 수를 list에 담고 정렬


* */
