package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16918 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int r, c, n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];

        if(n % 2 == 0) {
            for(int i=0 ; i<r ; i++) {
                for(int j=0 ; j<c ; j++) {
                    System.out.print('O');
                }
                System.out.println();
            }
            return;
        }

        for(int i=0 ; i<r ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<c ; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int k=2 ; k<=n ; k++) {
            if(k % 2 == 1) {
                for(int i=0 ; i<r ; i++) {
                    for(int j=0 ; j<c ; j++) {
                        if(map[i][j] == 'O')
                            queue.add(new int[] {i, j});
                    }
                }
                for(char[] ch : map) {
                    Arrays.fill(ch, 'O');
                }
                while (!queue.isEmpty()) {
                    int[] temp = queue.poll();
                    int tx = temp[0];
                    int ty = temp[1];
                    map[tx][ty] = '.';
                    for(int i=0 ; i<4 ; i++) {
                        int nx = tx + dx[i];
                        int ny = ty + dy[i];
                        if(nx>=0 && ny>=0 && nx<r && ny<c) {
                            if(map[nx][ny] == 'O')
                                map[nx][ny] = '.';
                        }
                    }
                }
            }
        }
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<c ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
