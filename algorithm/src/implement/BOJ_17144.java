package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.MemoryNotificationInfo;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int r, c, t;
    static int[][] map;

    static int upx = 0, downx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for(int i=0 ; i<r ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<c ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1 && upx == 0 && downx == 0) {
                    upx = i;
                    downx = i+1;
                }
            }
        }

        while (t-- > 0) {
            map = diffuse();
            wind();
        }
        int result = 0;
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                if(map[i][j] != -1)
                    result += map[i][j];
            }
        }
        System.out.println(result);
    }
    private static void wind() {
        for(int i=upx-1 ; i>0 ; i--)
            map[i][0] = map[i-1][0];

        for(int i=0 ; i<c-1 ; i++)
            map[0][i] = map[0][i+1];

        for(int i=0 ; i<upx ; i++)
            map[i][c-1] = map[i+1][c-1];

        for(int i=c-1 ; i>1 ; i--)
            map[upx][i] = map[upx][i-1];

        map[upx][1] = 0;

        for(int i=downx+1 ; i<r-1 ; i++)
            map[i][0] = map[i+1][0];

        for(int i=0 ; i<c-1 ; i++)
            map[r-1][i] = map[r-1][i+1];

        for(int i=r-1 ; i>downx ; i--)
            map[i][c-1] = map[i-1][c-1];

        for(int i=c-1 ; i>1 ; i--)
            map[downx][i] = map[downx][i-1];

        map[downx][1] = 0;
    }

    private static int[][] diffuse() {
        int[][] nMap = new int[r][c];
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                if(map[i][j] == -1)
                    nMap[i][j] = -1;
                else if(map[i][j] > 0){
                    nMap[i][j] += map[i][j];
                    for(int k=0 ; k<4 ; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx>=0 && ny>=0 && nx<r && ny<c && map[nx][ny] != -1) {
                            nMap[nx][ny] += (map[i][j] / 5);
                            nMap[i][j] -= (map[i][j] / 5);
                        }
                    }
                }
            }
        }

        return nMap;
    }
}
