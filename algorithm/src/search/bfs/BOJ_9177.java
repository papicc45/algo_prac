package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9177 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t=0 ; t<n ; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] w1 = st.nextToken().toCharArray();
            char[] w2 = st.nextToken().toCharArray();
            char[] comb = st.nextToken().toCharArray();

            System.out.print("Data set " + (t+1) + ": ");
            System.out.println(bfs(w1, w2, comb) ? "yes" : "no");

        }
    }
    private static boolean bfs(char[] w1, char[] w2, char[] comb) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        boolean[][] visited = new boolean[w1.length+1][w2.length+1];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int idx1 = temp[0];
            int idx2 = temp[1];

            if(idx1 + idx2 == comb.length)
                return true;

            if(idx1 < w1.length && comb[idx1 + idx2] == w1[idx1]) {
                if(!visited[idx1+1][idx2]) {
                    visited[idx1+1][idx2] = true;
                    queue.add(new int[] {idx1+1, idx2});
                }
            }

            if(idx2 < w2.length && comb[idx1 + idx2] == w2[idx2]) {
                if(!visited[idx1][idx2+1]) {
                    visited[idx1][idx2+1] = true;
                    queue.add(new int[] {idx1, idx2+1});
                }
            }
        }
        return false;
    }
}
