package search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2412 {
    static int n, t;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        list = new ArrayList[t+1];
        for(int i=0 ; i<=t ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            list[y].add(x);
        }

        for(int i=0 ; i<=t ; i++)
            Collections.sort(list[i]);

        bfs();
        if(answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }
    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        int cnt = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i=0 ; i<size ; i++) {
                int[] temp = queue.poll();
                int x = temp[0];
                int y = temp[1];

                if(y == t) {
                    answer = cnt;
                    return;
                }

                for(int ny=y-2 ; ny<=y+2 ; ny++) {
                    if(ny<0 || ny > t) continue;

                    for(int idx=0 ; idx<list[ny].size() ; idx++) {
                        if(x+2 < list[ny].get(idx)) break;
                        if(x-2 > list[ny].get(idx)) continue;

                        queue.add(new int[] {list[ny].get(idx), ny});
                        list[ny].remove(idx);
                        idx--;
                    }
                }
            }
            cnt++;
        }
    }
}
