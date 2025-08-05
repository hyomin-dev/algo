import java.io.*;
import java.util.*;

public class Main {

    static int n,m,x;
    static ArrayList<ArrayList<Node1238>> graph = new ArrayList<>();
    static int[][] distMatrix;
    static final int INF = (int)1e9;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 마을의 숫자
        m = Integer.parseInt(st.nextToken()); // 단방향 도로의 개수
        x = Integer.parseInt(st.nextToken()); // 파티하는 마을

        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());
        distMatrix = new int[n+1][n+1];

        for(int i=1;i<=n;i++)
            Arrays.fill(distMatrix[i], INF);

        for(int i=1;i<=n;i++)
            distMatrix[i][i] = 0;

        while(m>0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node1238(end, cost)); // 단방향 도로
            m--;
        }

        for(int i=1;i<=n;i++){
            dijkstra(i);
        }

        int[] resultArray = new int[n+1];

        for(int i=1;i<=n;i++){
            //x마을로 가는데 걸리는 시간 + x마을에서 자신의 마을로 돌아가는데 걸리는 시간
            resultArray[i] += distMatrix[i][x] + distMatrix[x][i];
        }

        Arrays.sort(resultArray);

        bw.write(resultArray[n]+"");

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node1238> pq = new PriorityQueue<>();
        pq.offer(new Node1238(start, 0));

        while(!pq.isEmpty()){
            Node1238 now = pq.poll();

            if(distMatrix[start][now.getIndex()]<now.getCost()) // 이미 구한 최소 거리가 있으면 건너뜀
                continue;

            for(int i=0;i<graph.get(now.getIndex()).size();i++){
                Node1238 adjcencyNode = graph.get(now.getIndex()).get(i);
                int cost = now.getCost() + graph.get(now.getIndex()).get(i).getCost();
                if(distMatrix[start][adjcencyNode.getIndex()]>cost){
                    distMatrix[start][adjcencyNode.getIndex()] = cost;
                    pq.offer(new Node1238(graph.get(now.getIndex()).get(i).getIndex(), cost));
                }
            }
        }
    }
}

class Node1238 implements Comparable<Node1238>{
    private int index;
    private int cost;

    public Node1238(int index, int cost){
        this.index = index;
        this.cost = cost;
    }

    public int getIndex(){
        return this.index;
    }

    public int getCost(){
        return this.cost;
    }

    @Override
    public int compareTo(Node1238 o){
        return this.cost - o.cost;
    }
}
