package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_6443 {
    static BufferedWriter bw;
    static int N, length;
    static char[] alphas, ana, max;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            alphas = br.readLine().toCharArray();
            length = alphas.length;

            visited = new boolean[length];
            max = new char[length];
            ana = new char[length];

            Arrays.sort(alphas);
            backTracking(0);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void backTracking(int depth) throws IOException {
        if (depth == length) {
            bw.write(ana);
            bw.write('\n');
            return;
        }

        max[depth] = 0;
        for (int i = 0; i < length; i++) {
            if(max[depth] >= alphas[i]) continue;
            if (!visited[i]) {
                visited[i] = true;
                max[depth] = ana[depth] = alphas[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}