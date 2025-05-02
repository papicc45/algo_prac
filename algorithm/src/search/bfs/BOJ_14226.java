package search.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14226 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bfs(n);
    }
    private static void bfs(int n) {
        boolean[][] visited = new boolean[1001][1001];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 1, 0});
        // 0번째 - time,
        // 1번째 - 현재 작성된 이모티콘 갯수,
        // 2번째 - 클립보드에 있는 이모티콘 갯수
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int tt = temp[0];
            int emocnt = temp[1];
            int clipcnt = temp[2];

            if(emocnt == n) {
                System.out.println(tt);
                return;
            }

            queue.add(new int[] {tt+1, emocnt, emocnt});

            if(clipcnt != 0 && emocnt + clipcnt <= n && !visited[clipcnt][emocnt + clipcnt]) {
                queue.add(new int[] {tt+1, emocnt + clipcnt, clipcnt});
                visited[clipcnt][emocnt + clipcnt] = true;
            }

            if(emocnt > 0 && !visited[clipcnt][emocnt - 1]) {
                queue.add(new int[] {tt+1, emocnt-1, clipcnt});
                visited[clipcnt][emocnt - 1] = true;
            }
        }
    }
}
