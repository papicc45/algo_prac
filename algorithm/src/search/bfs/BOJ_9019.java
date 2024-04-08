package search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019 {
    static int b;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            System.out.println(BFS(a));
        }
    }
    private static String BFS(int a) {
        String result = "";
        visited = new boolean[10000];
        Queue<Cal> queue = new LinkedList<>();
        queue.add(new Cal(a, ""));
        visited[a] = true;
        while (!queue.isEmpty()) {
            Cal temp = queue.poll();
            int num = temp.num;
            String order = temp.order;

            if(num == b) {
                result = order;
                break;
            }
            int d = (num * 2) % 10000;
            if(!visited[d]) {
                visited[d] = true;
                queue.add(new Cal(d, order + "D"));
            }
            int s = num == 0 ? 9999 : num - 1;
            if(!visited[s]) {
                visited[s] = true;
                queue.add(new Cal(s, order + "S"));
            }
            int l = num / 1000 + (num % 1000) * 10;
            if(!visited[l]) {
                visited[l] = true;
                queue.add(new Cal(l, order + "L"));
            }
            int r = (num % 10) * 1000 + num / 10;
            if(!visited[r]) {
                visited[r] = true;
                queue.add(new Cal(r, order + "R"));
            }
        }

        return result;
    }
    static class Cal {
        int num;
        String order;

        public Cal(int num, String order) {
            this.num = num;
            this.order = order;
        }
    }
}
