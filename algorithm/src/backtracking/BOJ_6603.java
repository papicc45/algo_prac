package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static boolean[] visited;
    static int[] arr;
    static int[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if(n == 0)
                break;

            arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            answer = new int[6];
            visited = new boolean[n];

            recur(0, 0);
            System.out.println();
        }

    }
    private static void recur(int depth, int idx) {
        if(depth == 6) {
            for(int i=0 ; i<answer.length ; i++)
                System.out.print(answer[i] + " ");

            System.out.println();
            return;
        }

        for(int i=idx ; i<arr.length ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                recur(depth+1, i);
                visited[i] = false;
            }
        }
    }

}
