package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3085 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][n];
        for(int i=0 ; i<n ; i++) {
            char[] chs = br.readLine().toCharArray();
            for(int j=0 ; j<n ; j++) {
                arr[i][j] = chs[j];
            }
        }
        check(n, arr);
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<n ; j++) {
                for(int k=0 ; k<4 ; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if(x < 0 || x >= n || y < 0 || y >= n) continue;
                    if(arr[i][j] != arr[x][y]) {
                        char tmp = arr[i][j];
                        arr[i][j] = arr[x][y];
                        arr[x][y] = tmp;
                        check(n, arr);
                        tmp = arr[x][y];
                        arr[x][y] = arr[i][j];
                        arr[i][j] = tmp;
                    }
                }
            }
        }
        System.out.println(result);
    }
    private static void check(int n, char[][] arr) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    result = Math.max(result, cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result, cnt);
        }

        for (int j = 0; j < n; j++) {
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    cnt++;
                } else {
                    result = Math.max(result, cnt);
                    cnt = 1;
                }
            }
            result = Math.max(result, cnt);
        }
    }
}
