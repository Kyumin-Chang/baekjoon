import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            sb.append(i + 1);
            sb.append(" ");
            String line = reader.readLine();
            String[] lines = line.split(" ");
            int[] heights = new int[20];
            for (int j = 1; j < 21; j++) {
                heights[j - 1] = Integer.parseInt(lines[j]);
            }
            sb.append(sort(heights));
            if (i == t - 1) {
                break;
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int sort(int[] heights) {
        int count = 0;
        int temp;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] > heights[j]) {
                    temp = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp;
                    count++;
                }
            }
        }
        return count;
    }
}
