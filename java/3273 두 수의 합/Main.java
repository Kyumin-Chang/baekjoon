import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(reader.readLine());
        int answer = 0;
        boolean[] exits = new boolean[1000001];
        for (int i = 0; i < n; i++) {
            exits[arr[i]] = true;
        }
        for (int i = 0; i < n; i++) {
            int m = target - arr[i];
            if (m > 0 && m < 1000001) {
                if (exits[m]) {
                    answer++;
                }
            }
        }
        System.out.println(answer / 2);
    }
}
