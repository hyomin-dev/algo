import java.io.*;
import java.util.*;

public class Main {
    static int n, m, r;
    static int[][] graph;
    static int[] items;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        items = new int[n+1];

        for(int y=1;y<=n;y++)
            Arrays.fill(graph[y],INF);

        for(int i=1;i<=n;i++) // 자기 자신으로 가는 거리는 0
            graph[i][i] = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) // 각 노드에서 얻을 수 있는 아이템 수
            items[i] = Integer.parseInt(st.nextToken());

        while(r>0){ // a노드에서 b노드로 가는 거리 설정

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[a][b] = l;
            graph[b][a] = l;

            r--;
        }

        for(int k=1;k<=n;k++){
            for(int y=1;y<=n;y++){
                for(int x=1;x<=n;x++){
                    graph[y][x] = Math.min(graph[y][x], graph[y][k] + graph[k][x]);
                }
            }
        }

        // graph[i][j]: i에서 j로 가는 최단 거리,

        // 각 노드에 착지 했을 때 얻을 수 있는 최대 아이템
        int[] maxItems = new int[n+1];

        for(int y=1;y<=n;y++){
            for(int x=1;x<=n;x++){
                if(graph[y][x]<=m)
                    maxItems[y] += items[x];
            }
        }

        Arrays.sort(maxItems);

        bw.write(maxItems[n]+"");
        bw.flush();
        br.close();

    }
}
