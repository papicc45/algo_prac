package recursion;

import javax.management.relation.Relation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.StringTokenizer;

public class BOJ_17085 {
    static char[][] map;
    static int n, m;
    static boolean[][] visited;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = arr[j];
            }
        }

        visited = new boolean[n][m];
        dfs(0, 1);
        System.out.println(result);
    }

    // cnt: 선택한 십자가 개수, areaProduct: 지금까지 면적 곱
    private static void dfs(int cnt, int areaProduct) {
        if (cnt == 2) {
            result = Math.max(result, areaProduct);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '#' || visited[i][j]) continue;
                // 현재 상태에서 가능한 최대 size 계산 (arms 포함, 비중첩)
                int maxSize = getMaxSize(i, j);
                // 중심만 마킹
                visited[i][j] = true;
                // size = 1~maxSize => arm = size-1
                for (int size = 1; size <= maxSize; size++) {
                    int arm = size - 1;
                    // 팔 영역 마킹
                    for (int d = 1; d <= arm; d++) {
                        visited[i + d][j] = true;
                        visited[i - d][j] = true;
                        visited[i][j + d] = true;
                        visited[i][j - d] = true;
                    }
                    int area = 1 + 4 * arm;
                    dfs(cnt + 1, areaProduct * area);
                    // 팔 영역 언마킹
                    for (int d = 1; d <= arm; d++) {
                        visited[i + d][j] = false;
                        visited[i - d][j] = false;
                        visited[i][j + d] = false;
                        visited[i][j - d] = false;
                    }
                }
                // 중심 언마킹
                visited[i][j] = false;
            }
        }
    }

    // (x,y)에서 visited 겹치지 않는 최대 size 반환
    private static int getMaxSize(int x, int y) {
        int size = 0;
        while (true) {
            int arm = size;
            // 경계 체크
            if (x - arm < 0 || x + arm >= n || y - arm < 0 || y + arm >= m) break;
            // 중심 및 팔 위치 '#'이고, 방문되지 않아야 함
            if (map[x][y] != '#' || visited[x][y]) break;
            if (map[x - arm][y] != '#' || visited[x - arm][y]) break;
            if (map[x + arm][y] != '#' || visited[x + arm][y]) break;
            if (map[x][y - arm] != '#' || visited[x][y - arm]) break;
            if (map[x][y + arm] != '#' || visited[x][y + arm]) break;
            size++;
        }
        return size;
    }
}
