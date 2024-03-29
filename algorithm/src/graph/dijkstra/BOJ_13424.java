package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13424 {
    static boolean[] visited;
    static ArrayList<Room>[] list;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            for(int i=0 ; i<=n ; i++)
                list[i] = new ArrayList<>();

            for(int i=0 ; i<m ; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int length = Integer.parseInt(st.nextToken());
                list[start].add(new Room(end, length));
                list[end].add(new Room(start, length));
            }

            int k = Integer.parseInt(br.readLine());
            int[] people = new int[k];
            st = new StringTokenizer(br.readLine());
            for(int i=0 ; i<k ; i++) {
                people[i] = Integer.parseInt(st.nextToken());
            }

            int[] arr = new int[n+1];
            for(int i=0 ; i<k ; i++) {
                int[] sum = dijkstra(people[i]);
                for(int j=1 ; j<=n ; j++) {
                    arr[j] += sum[j];
                }
            }
            int min = Integer.MAX_VALUE;
            int result = 0;
            for(int i=1 ; i<=n ; i++) {
                if(min > arr[i]) {
                    min = arr[i];
                    result = i;
                }
            }
            System.out.println(result);
        }
    }
    private static int[] dijkstra(int index) {
        PriorityQueue<Room> queue = new PriorityQueue<>();
        visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[index] = 0;
        queue.add(new Room(index, 0));

        while (!queue.isEmpty()) {
            Room temp = queue.poll();

            if(visited[temp.number]) continue;

            visited[temp.number] = true;

            for(Room next : list[temp.number]) {
                if(!visited[next.number]) {
                    if(dist[next.number] > dist[temp.number] + next.length) {
                        dist[next.number] = dist[temp.number] + next.length;
                        queue.add(new Room(next.number, dist[next.number]));
                    }
                }
            }
        }
        return dist;
    }
    static class Room implements Comparable<Room> {
        int number;
        int length;

        public Room(int number, int length) {
            this.number = number;
            this.length = length;
        }

        @Override
        public int compareTo(Room o) {
            return this.length - o.length;
        }
    }
}
