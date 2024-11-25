import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(reader.readLine());
        int[] cnt = new int[10001];
        for (int i = 0; i < N; i++) {
            cnt[Integer.parseInt(reader.readLine())]++;
        }
        for (int i = 1; i <= 10000; i++) {
            while (cnt[i] > 0) {
                sb.append(i).append("\n");
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}
