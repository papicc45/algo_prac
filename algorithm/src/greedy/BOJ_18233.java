package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18233 {
    static Range[] ranges;
    static int[][] arr;
    static int n, p, e;
    static int[] ducks;
    static int[] result;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        arr = new int[n][2];
        ducks = new int[n];
        result = new int[n];
        ranges = new Range[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ranges[i] = new Range(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recur(0, 0);
        StringBuilder sb = new StringBuilder();
        if (check) {
            for (int i : result)
                sb.append(i).append(" ");

            System.out.println(sb.toString());
        } else {
            System.out.println("-1");
        }

    }

    private static void recur(int cnt, int depth) {
        if (cnt != p) {
            for (int i = depth; i < n; i++) {
                ducks[cnt] = i;
                recur(cnt + 1, i + 1);

                if (check)
                    return;
            }
        } else {
            int min = 0;
            int max = 0;
            for (int i = 0; i < p; i++) {
                min += ranges[ducks[i]].min;
                max += ranges[ducks[i]].max;
            }

            if (e < min || max < e)
                return;

            check = true;
            int diff = e - min;

            for (int i = 0; i < p; i++) {
                result[ducks[i]] += ranges[ducks[i]].min;
                if (diff != 0) {
                    int remain = ranges[ducks[i]].max - ranges[ducks[i]].min;
                    if (remain < diff) {
                        result[ducks[i]] += remain;
                        diff -= remain;
                    } else {
                        result[ducks[i]] += diff;
                        diff = 0;
                    }
                }
            }
        }
    }

    static class Range {
        int min, max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
}
