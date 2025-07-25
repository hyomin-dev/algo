import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n+1][n+1];

        for(int y=1;y<=n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=1;x<=n;x++){
                matrix[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=1;y<=n;y++){
            for(int x=2;x<=n;x++){
                matrix[y][x] = matrix[y][x] + matrix[y][x-1]; // 각 행별로 우측 방향으로 누적합을 구합
            }
        }

        while(m>0){
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());


            int sum = 0;
            for(int x=x2;x>=x1;x--){
                sum += matrix[x][y2]; // [x1~x2][y2]를 더한다.
                sum -= matrix[x][y1-1]; //[x1~x2][y1-1]를 뺀다.
            }

            bw.write(sum+"\n");

            m--;
        }

        bw.flush();
        bw.close();
        br.close();

    }
}

/*

각 행별로 우측으로 누적합을 구한다.
* */