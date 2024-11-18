import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        String[] castle = new String[n];
        int first = 0;
        int second = 0;

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (!line.contains("X")) {
                first++;
            }
            castle[i] = line;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (castle[j].charAt(i) == 'X') {
                    break;
                }
                if (j == n - 1) {
                    second++;
                }
            }
        }
        System.out.println(Math.max(first, second));
    }
}
