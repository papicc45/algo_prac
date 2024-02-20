package search.bfs;

import java.io.*;
import java.util.*;

public class BOJ_3197 {
    static int r, c;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static char[][] originMap;
    static boolean[][] visited;
    static Queue<int[]> waterQueue = new LinkedList<>(); // 다음에 녹을 물의 위치를 저장하는 큐
    static Queue<int[]> swanQueue = new LinkedList<>(); // 백조의 이동 경로를 탐색하는 큐
    static int[] swanPos = new int[2]; // 두 번째 백조의 위치 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        originMap = new char[r][c];
        visited = new boolean[r][c];

        boolean firstSwan = true;
        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                originMap[i][j] = line.charAt(j);
                if(originMap[i][j] == 'L') {
                    if(firstSwan) {
                        swanQueue.add(new int[]{i, j});
                        firstSwan = false;
                    } else {
                        swanPos[0] = i;
                        swanPos[1] = j;
                    }
                    originMap[i][j] = '.'; // 백조 위치를 물로 변경
                }
                if(originMap[i][j] == '.') {
                    waterQueue.add(new int[]{i, j});
                }
            }
        }

        int days = 0;
        while(!findSwan()) {
            meltIce();
            days++;
        }
        System.out.println(days);
    }

    private static boolean findSwan() {
        Queue<int[]> nextQueue = new LinkedList<>();
        while (!swanQueue.isEmpty()) {
            int[] pos = swanQueue.poll();
            int x = pos[0], y = pos[1];

            if(x == swanPos[0] && y == swanPos[1]) return true; // 다른 백조를 만난 경우

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if(originMap[nx][ny] == '.') {
                        swanQueue.add(new int[]{nx, ny});
                    } else if(originMap[nx][ny] == 'X') {
                        nextQueue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        swanQueue = nextQueue; // 다음 날 탐색할 위치 업데이트
        return false;
    }

    private static void meltIce() {
        int size = waterQueue.size();
        for(int i = 0; i < size; i++) {
            int[] pos = waterQueue.poll();
            int x = pos[0], y = pos[1];

            for(int j = 0; j < 4; j++) {
                int nx = x + dx[j], ny = y + dy[j];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && originMap[nx][ny] == 'X') {
                    originMap[nx][ny] = '.'; // 얼음 녹이기
                    waterQueue.add(new int[]{nx, ny});
                }
            }
        }
    }
}
