import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        bw.write(a.add(b).toString());
        bw.newLine();
        bw.write(a.subtract(b).toString());
        bw.newLine();
        bw.write(a.multiply(b).toString());
        bw.newLine();

        bw.flush();
        bw.close();
        br.close();

    }
}
