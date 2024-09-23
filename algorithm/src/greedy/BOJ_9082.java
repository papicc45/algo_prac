package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_9082 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=0 ; tc<t ; t++) {
            int n = Integer.parseInt(br.readLine());
            char[] idxs = br.readLine().toCharArray();
            Mine[] mines = new Mine[n];

            for (int i = 0; i < n; i++) {
                mines[i] = new Mine(i, idxs[i] - '0');
            }
            Arrays.sort(mines);
            char[] arr = br.readLine().toCharArray();

            for(int i=0 ; i<n ; i++) {
                Mine mine = mines[i];
                int cnt = 0;
                int left = mine.idx - 1 >= 0 ? mine.idx-1 : 0;
                int right = mine.idx + 1 < n ? mine.idx+1 : n-1;

            }
            int result = 0;
            for(int i=0 ; i<n ; i++) {
                if(arr[i] == '*')
                    result++;
            }
            System.out.println(result);
        }
    }
    static class Mine implements Comparable<Mine> {
        int idx;
        int num;

        public Mine(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public int compareTo(Mine o) {
            return o.num - this.num;
        }
    }
}
