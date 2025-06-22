package implement;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10703 {
    static char[][] map;
    static int r, s;
    static int[][] idx;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        map = new char[r][s];

        for(int i=0 ; i<r ; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j=0 ; j<s ; j++) {
                map[i][j] = arr[j];
            }
        }

        idx = new int[s][2];
        for(int i=0 ; i<s ; i++) {
            int d = r-1;
            int groundpos = 0;
            while (d >= 0 && map[d][i] != 'X') {
                if(map[d][i] == '#') {
                    groundpos = d;
                }
                d--;
            }

            if(d == -1) continue;
            int diff = groundpos - d - 1;
            min = Math.min(diff, min);
            idx[i][0] = diff;
            idx[i][1] = d;
        }

        for(int i=0 ; i<s ; i++) {
            if(idx[i][0] == 0) continue;
            for(int j=idx[i][1] ; j>=0 ; j--) {
                if(map[j][i] == '.') continue;

                map[j+min][i] = 'X';
                map[j][i] = '.';
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0 ; i<r ; i++) {
            for(int j=0 ; j<s ; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
