package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] visited;
    static int n, m;
    static int max = 0;
    static int sx, sy;
    static int rainbow;
    static ArrayList<int[]> maxGroupList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        while (true) {
            sx = 0;
            sy = 0;
            rainbow = 0;
            max = 0;
            maxGroupList = new ArrayList<>();

            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<n ; j++) {
                    if(map[i][j] != -1 && map[i][j] != 0 && map[i][j] != -2) {
                        getMaxSizeBlockGroup(i, j);
                    }
                }
            }

            if(max == 0) break;
            result += (int)Math.pow(max, 2);

            for(int[] group : maxGroupList) {
                map[group[0]][group[1]] = -2;
            }

            gravity();
            turn();
            gravity();
        }

        System.out.println(result);
    }
    private static void turn() {
        int[][] copyMap = new int[n][n];
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                copyMap[i][j] = map[j][n-i-1];
            }
        }
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                map[i][j] = copyMap[i][j];
            }
        }
    }
    private static void gravity() {
        for(int col = 0; col<n ; col++) {
            int target = n-1;

            for(int row=n-1 ; row>=0 ; row--) {
                if (map[row][col] == -1) {
                    target = row - 1;
                } else if(map[row][col] >= 0) {
                    int block = map[row][col];
                    map[row][col] = -2;
                    map[target][col] = block;
                    target--;
                }
            }
        }
    }
    private static void getMaxSizeBlockGroup(int x, int y) {
        visited = new boolean[n][n];
        ArrayList<int[]> list = new ArrayList<>();
        visited[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int color = map[x][y];
        int r = 0;
        int mx = Integer.MAX_VALUE, my = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            list.add(temp);

            if (map[temp[0]][temp[1]] != 0) {
                if (temp[0] < mx) {
                    mx = temp[0];
                    my = temp[1];
                } else if (temp[0] == mx) {
                    if (temp[1] < my) {
                        mx = temp[0];
                        my = temp[1];
                    }
                }
            }

            if (map[temp[0]][temp[1]] == 0)
                r++;

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;

                if (map[nx][ny] == color || map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        if(list.size() < 2)
            return;

        if (list.size() > max
                || (list.size() == max
                && (r > rainbow
                || (r == rainbow
                && (mx > sx
                || (mx == sx && my > sy)
        )
        )
        )
        )
        ) {
            max = list.size();
            maxGroupList = list;
            rainbow = r;
            sx = mx;
            sy = my;
        }
    }
}
