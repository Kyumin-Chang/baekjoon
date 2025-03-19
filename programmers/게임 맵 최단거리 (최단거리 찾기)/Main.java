package org.example;

import java.util.ArrayDeque;

class Main {

    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }

    public static int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        int[][] visited = new int[N][M];

        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.addLast(new Node(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + rx[i];
                int ny = now.y + ry[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }

                if (maps[nx][ny] == 0) {
                    continue;
                }

                if (visited[nx][ny] == 0) {
                    queue.addLast(new Node(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }
        return visited[N - 1][M - 1] == 0 ? -1 : visited[N - 1][M - 1];
    }

    private static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
