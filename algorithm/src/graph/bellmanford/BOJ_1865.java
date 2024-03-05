package graph.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[] dist = new int[n+1];
            ArrayList<Route> list = new ArrayList<>();
            for(int i=0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                list.add(new Route(start, end, len));
                list.add(new Route(end, start, len));
            }
            for(int i=0 ; i<w ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int len = Integer.parseInt(st.nextToken());

                list.add(new Route(start, end, -len));
            }
            boolean result = false;
            Arrays.fill(dist, 987654321);
            dist[1] = 0;
            result = check(dist, list, n);
            if(result)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
    private static boolean check(int[] dist, ArrayList<Route> list, int n) {
        for(int i=0 ; i<n-1 ; i++) {
            for(int j=0 ; j<list.size() ; j++) {
                Route route = list.get(j);

                if(dist[route.end] > dist[route.start] + route.len) {
                    dist[route.end] = dist[route.start] + route.len;
                }
            }
        }

        boolean check = false;
        for(int i=0 ; i<list.size() ; i++) {
            Route route = list.get(i);

            if(dist[route.end] > dist[route.start] + route.len) {
                check = true;
                break;
            }
        }
        return check;
    }
    static class Route {
        int start;
        int end;
        int len;

        Route(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }
    }
}
