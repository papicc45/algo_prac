package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1525 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        for(int i=0 ; i<3 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<3 ; j++) {
                str += st.nextToken();
            }

        }

        System.out.println(bfs(str));

    }
    private static int bfs(String str) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(str, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(str);

        while (!queue.isEmpty()) {
            String temp = queue.poll();
            int cnt = hm.get(temp);

            if(temp.equals("123456780")) {
                return cnt;
            }

            int index = temp.indexOf('0');
            int tx = index % 3;
            int ty = index / 3;

            for(int i=0 ; i<4 ; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if(nx>=0 && ny>=0 && nx<3 && ny<3) {
                    int tIndex = nx + ny * 3;
                    char ch = temp.charAt(tIndex);
                    String next = temp.replace(ch, 'x');
                    next = next.replace('0', ch);
                    next = next.replace('x', '0');

                    if(!hm.containsKey(next)) {
                        queue.add(next);
                        hm.put(next, cnt + 1);
                    }
                }
            }
        }

        return -1;
    }
}
