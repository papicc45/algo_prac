package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15663 {
    static Set<String> set;
    static int n, m;
    static int[] arr;
    static int[] answer;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        visited = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        set = new LinkedHashSet<>();
        Arrays.sort(arr);
        recur(0);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
    private static void recur(int depth) {
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int i=0 ; i<m ; i++) {
                sb.append(answer[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                recur(depth + 1);
                visited[i] = false;
            }
        }
    }
}
