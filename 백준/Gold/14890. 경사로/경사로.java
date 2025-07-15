import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 2 <= n <= 100
        int l = Integer.parseInt(st.nextToken()); // 1 <= l <= n

        int[][] map = new int[n][n];
        for(int y=0;y<n;y++){
            st = new StringTokenizer(br.readLine());
            for(int x=0;x<n;x++){
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0; // 길 개수

        // 가로 길
        for(int y=0;y<n;y++){

            //왼쪽 출발
            int prevH = map[y][0];
            int roadLength = 1; // 같은 높이의 도로 길이
            for(int x=1;x<n;x++){

                if(Math.abs(prevH-map[y][x])>1) // 인접한 도로의 높이차가 2이상인 경우
                    break;

                if(prevH==map[y][x]) // 높이가 같은 경우
                    roadLength++;
                else if(prevH==map[y][x]+1) { // 왼쪽이 더 높은 경우
                    int currH = map[y][x];
                    int sameRoadLength = 1;
                    for(int xx=x+1;xx<n;xx++) { // 현재 도로부터 다음 도로 까지 같은 높이의 길이를 구함
                        if(sameRoadLength==l) // 경사로를 만들 수 있는 경우
                            break;

                        if(currH==map[y][xx])
                            sameRoadLength++;
                        else
                            break;

                    }
                    if(sameRoadLength==l){ // 경사로를 만들 수 있는 경우
                        prevH = map[y][x]; // 이전 높이를 변경
                        roadLength = -(l-1); // 높이가 바뀜, l-1만큼 빌려 쓴 것이기 때문에

                    }else{// 경사로를 만들 수 없음
                        break;
                    }

                }else if(prevH+1==map[y][x]){ // 오른쪽이 더 높은 경우
                    if(roadLength>=l){ // 경사로를 만들 수 있음
                        prevH = map[y][x]; // 이전 높이를 변경
                        roadLength = 1; // 같은 높이의 도로의 길이를 초기화
                    }else{ // 경사로를 만들 수 없음
                        break;
                    }
                }

                if(x==n-1) // 왼쪽에서 출발해서 오른쪽 끝에 도달함 --> 길이 있음
                    count++;
            }
        }

        // 세로 길
        for(int x=0;x<n;x++){
            //위쪽 출발
            int prevH = map[0][x];
            int roadLength = 1; // 같은 높이의 도로 길이
            for(int y=1;y<n;y++){

                if(Math.abs(prevH-map[y][x])>1) // 인접한 도로의 높이차가 2이상인 경우
                    break;

                if(prevH==map[y][x]) // 높이가 같은 경우
                    roadLength++;
                else if(prevH==map[y][x]+1) { // 위쪽이 더 높은 경우
                    int currH = map[y][x];
                    int sameRoadLength = 1;
                    for(int yy=y+1;yy<n;yy++) { // 현재 도로부터 다음 도로 까지 같은 높이의 길이를 구함
                        if(sameRoadLength==l) // 경사로를 만들 수 있는 경우
                            break;

                        if(currH==map[yy][x])
                            sameRoadLength++;
                        else
                            break;

                    }
                    if(sameRoadLength==l){ // 경사로를 만들 수 있는 경우
                        prevH = map[y][x]; // 이전 높이를 변경
                        roadLength = -(l-1); // 높이가 바뀜, l-1만큼 빌려 쓴 것이기 때문에

                    }else{// 경사로를 만들 수 없음
                        break;
                    }

                }else if(prevH+1==map[y][x]){ // 아래쪽이 더 높은 경우
                    if(roadLength>=l){ // 경사로를 만들 수 있음
                        prevH = map[y][x]; // 이전 높이를 변경
                        roadLength = 1; // 같은 높이의 도로의 길이를 초기화
                    }else{ // 경사로를 만들 수 없음
                        break;
                    }
                }
                if(y==n-1) // 위쪽에서 출발해서 아래쪽 끝까지 도달함
                    count++;
            }

        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();

    }
}
