package graph.dijkstra;

import javax.swing.text.StyledEditorKit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.sql.Statement;
import java.util.*;

public class BOJ_17940 {
    static int n, m;
    static ArrayList<Station>[] list;
    static int[] company;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        company = new int[n];
        for(int i=0 ; i<n ; i++)
            list[i] = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            company[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                int l = Integer.parseInt(st.nextToken());
                if(l > 0) {
                    list[i].add(new Station(j, l, 0));
                }
            }
        }
        dijkstra();
    }
    private static void dijkstra() {
        PriorityQueue<Station> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        queue.add(new Station(0, 0, 0));
        while (!queue.isEmpty()) {
            Station temp = queue.poll();

            if(temp.goal == m) {
                System.out.println(temp.cnt + " " + temp.len);
                return;
            }

            if(visited[temp.goal]) continue;
            visited[temp.goal] = true;

            for(Station station : list[temp.goal]) {
                if(visited[station.goal]) continue;
                queue.add(new Station(station.goal, temp.len + station.len, company[temp.goal] != company[station.goal] ? temp.cnt + 1 : temp.cnt));
            }
        }
    }
    static class Station implements Comparable<Station> {
        int goal;
        int len;
        int cnt;

        public Station(int goal, int len, int cnt) {
            this.goal = goal;
            this.len = len;
            this.cnt = cnt;
        }
        @Override
        public int compareTo(Station o) {
            if(this.cnt == o.cnt) {
                return this.len - o.len;
            } else {
                return this.cnt - o.cnt;
            }
        }
    }
}
