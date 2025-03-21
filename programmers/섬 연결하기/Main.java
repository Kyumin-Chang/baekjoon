import java.util.*;

class Solution {
    private static int[] parent;

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }

    public int solution(int n, int[][] costs) {
        parent = new int[n];
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;
        int edges = 0;
        for (int[] edge : costs) {
            if (edges == n - 1) {
                break;
            }
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
                edges++;
            }
        }
        return answer;
    }
}
