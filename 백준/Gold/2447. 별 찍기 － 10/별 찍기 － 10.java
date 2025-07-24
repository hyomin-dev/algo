import java.io.*;
import java.util.*;

public class Main {
    static int[] powArray;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        powArray = new int[8];
        powArray[0] = 1;
        powArray[1] = 3;
        for(int i=2;i<8;i++)
            powArray[i] = powArray[i-1]*3;

        char[][] square = new char[powArray[7]+1][powArray[7]+1];
        for(int i=0;i<=powArray[7];i++)
            Arrays.fill(square[i],'*');

        int n = Integer.parseInt(br.readLine());
        int k=0;
        for(int i=1;i<8;i++)
            if(powArray[i]==n)
                k=i;
        removeStar(square, k, 1, 1);

        for(int y=1;y<=n;y++){
            for(int x=1;x<=n;x++)
                bw.write(square[y][x]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static void removeStar(char[][] square, int k, int startX, int startY){
        if(k==0)
            return;

        for(int y=startY+powArray[k-1];y<startY+2*powArray[k-1];y++){
            for(int x=startX+powArray[k-1];x<startX+2*powArray[k-1];x++)
                square[y][x] = ' ';
        }

        for(int y=startY;y<=startY+2*powArray[k-1];y+=powArray[k-1]){
            for(int x=startX;x<=startX+2*powArray[k-1];x+=powArray[k-1]){
                if(y==startY+powArray[k-1]&&x==startX+powArray[k-1])
                    continue;
                removeStar(square, k-1,x,y);
            }
        }

    }
}
