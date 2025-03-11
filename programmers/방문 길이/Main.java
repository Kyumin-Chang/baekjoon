import java.util.*;

class Solution {
    public int solution(String dirs) {
        int N = dirs.length();
        int[] present = {0, 0};
        int[] future = {0, 0};
        int answer = 0;
        List<int[]> visited = new ArrayList<int[]>();

        for (int i = 0; i < N; i++) {
            char direction = dirs.charAt(i);
            int[] mTemp = move(direction, present);
            if (!(mTemp[0] > 5 || mTemp[0] < -5 || mTemp[1] > 5 || mTemp[1] < -5)) {
                future = mTemp.clone();
            }
            int[] temp = {present[0], present[1], future[0], future[1]};
            int[] temp2 = {future[0], future[1], temp[0], temp[1]};
            if (!Arrays.equals(present, future) && visited.stream().noneMatch(a -> Arrays.equals(a, temp))) {
                answer++;
                visited.add(temp);
                visited.add(temp2);
            }
            present = future.clone();
        }
        return answer;
    }

    public static int[] move(char direction, int[] present) {
        int[] newPosition = Arrays.copyOf(present, present.length);

        return switch (direction) {
            case 'U' -> {
                newPosition[1]++;
                yield newPosition;
            }
            case 'D' -> {
                newPosition[1]--;
                yield newPosition;
            }
            case 'L' -> {
                newPosition[0]--;
                yield newPosition;
            }
            case 'R' -> {
                newPosition[0]++;
                yield newPosition;
            }
            default -> newPosition;
        };
    }
}
