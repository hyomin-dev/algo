import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;
        final int INF = (int)1e9;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n+1][n+1];

        for(int i=0;i<n+1;i++)
            Arrays.fill(graph[i],INF);

        for(int y=1;y<=n;y++){
            for(int x=1;x<=n;x++){
                if(x==y)
                    graph[y][x] = 0;
            }
        }

        while(m>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(graph[node1][node2]==INF)
                graph[node1][node2] = cost;
            else{
                if(graph[node1][node2]>cost)
                    graph[node1][node2] = cost;
            }

            m--;
        }

        for(int k=1;k<=n;k++){
            for(int y=1;y<=n;y++){
                for(int x=1;x<=n;x++){
                    graph[y][x] = Math.min(graph[y][x], graph[y][k]+graph[k][x]);
                }
            }
        }


        for(int y=1;y<=n;y++){
            for(int x=1;x<=n;x++){
                if(graph[y][x]==INF)
                    bw.write("0 ");
                else
                    bw.write(graph[y][x]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}