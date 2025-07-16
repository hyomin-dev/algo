import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;

    static ArrayList<ArrayList<Node11404>> graph = new ArrayList<>();
    static int[] distArray;
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());



        for(int i=0;i<=n;i++)
            graph.add(new ArrayList<>());

        while(m>0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(node1).add(new Node11404(node2, cost));
            m--;
        }

        for(int i=1;i<=n;i++){
            distArray = new int[n+1];
            Arrays.fill(distArray, INF);

            dijkstra(i);

            for(int j=1;j<=n;j++){
                if(j==i)
                    bw.write("0 ");
                else if(distArray[j]==INF)
                    bw.write("0 ");
                else
                    bw.write(distArray[j]+" ");
            }
            bw.newLine();

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void dijkstra(int start){
        PriorityQueue<Node11404> pq = new PriorityQueue<>();

        pq.offer(new Node11404(start,0));
        distArray[start] = 0;

        while(!pq.isEmpty()){

            Node11404 node = pq.poll();

            int now = node.getIndex();
            int distance = node.getDistance();

            if(distArray[now] < distance) // 이전에 최단 경로를 이미 구한 경우
                continue;

            for(int i=0;i<graph.get(now).size();i++){
                int adjcencyIndex = graph.get(now).get(i).getIndex();
                int cost = distArray[now] + graph.get(now).get(i).getDistance();

                if(cost < distArray[adjcencyIndex]){
                    distArray[adjcencyIndex] = cost;
                    pq.offer(new Node11404(adjcencyIndex,cost));
                }
            }
        }
    }
}

class Node11404 implements Comparable<Node11404>{
    int index;
    int distance;

    public Node11404(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    int getIndex(){
        return this.index;
    }

    int getDistance(){
        return this.distance;
    }

    @Override
    public int compareTo(Node11404 o){
        if(this.distance!=o.distance)
            return this.distance - o.distance;

        return 0;
    }

}

/*

n: 도시의 개수
m: 버스의 개수, 한 도시에서 출발해서 다른 도시에 도착함

도시 A에서 B로 가는데 필요한 비용의 최솟값을 구해야함
* */