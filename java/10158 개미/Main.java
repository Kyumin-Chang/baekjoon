import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int w = Integer.parseInt(tokenizer.nextToken());
        int h = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int p = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());

        int t = Integer.parseInt(reader.readLine());

        int a = (p + t) / w;
        int b = (p + t) % w;

        int c = (q + t) / h;
        int d = (q + t) % h;

        if (a % 2 != 0) {
            sb.append(w - b);
        } else {
            sb.append(b);
        }

        sb.append(" ");

        if (c % 2 != 0) {
            sb.append(h - d);
        } else {
            sb.append(d);
        }

        System.out.println(sb);
    }
}
