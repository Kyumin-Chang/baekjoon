import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] candies = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                candies[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j + 1 < N && candies[i][j] != candies[i][j + 1]) {
                    swapCandy(candies, i, j, i, j + 1);
                    ans = Math.max(ans, Math.max(findMaxColumn(candies), findMaxRow(candies)));
                    swapCandy(candies, i, j, i, j + 1);
                }
                if (i + 1 < N && candies[i][j] != candies[i + 1][j]) {
                    swapCandy(candies, i, j, i + 1, j);
                    ans = Math.max(ans, Math.max(findMaxColumn(candies), findMaxRow(candies)));
                    swapCandy(candies, i, j, i + 1, j);
                }
            }
        }

        System.out.println(ans);
    }

    static void swapCandy(char[][] candies, int r1, int c1, int r2, int c2) {
        char temp = candies[r1][c1];
        candies[r1][c1] = candies[r2][c2];
        candies[r2][c2] = temp;
    }

    static int findMaxRow(char[][] candies) {
        int N = candies.length;
        int MaxRow = 0;
        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if (candies[i][j] == candies[i][j - 1]) {
                    len++;
                } else {
                    MaxRow = Math.max(MaxRow, len);
                    len = 1;
                }
            }
            MaxRow = Math.max(MaxRow, len);
        }
        return MaxRow;
    }

    static int findMaxColumn(char[][] candies) {
        int N = candies.length;
        int MaxColumn = 0;
        for (int i = 0; i < N; i++) {
            int len = 1;
            for (int j = 1; j < N; j++) {
                if (candies[j][i] == candies[j - 1][i]) {
                    len++;
                } else {
                    MaxColumn = Math.max(MaxColumn, len);
                    len = 1;
                }
            }
            MaxColumn = Math.max(MaxColumn, len);
        }
        return MaxColumn;
    }
}
