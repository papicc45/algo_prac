package greedy;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.PolicyQualifierInfo;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14595 {
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        check = new boolean[n+1];

        PriorityQueue<Room> queue = new PriorityQueue<>();
        for(int i=0 ; i<m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new Room(start, end));
        }

        int max = 0;
        int cnt = 0;
        while(!queue.isEmpty()) {
            Room temp = queue.poll();
            if(max < temp.start) {
                for(int i=temp.start ; i<=temp.end ; i++) {
                    check[i] = true;
                }
                cnt++;
                max = temp.end;
            } else if(temp.start <= max && max <= temp.end) {
                for(int i=max+1 ; i<=temp.end ; i++) {
                    check[i] = true;
                }
                max = temp.end;
            }
        }
        for(int i=1 ; i<=n ; i++) {
            if(!check[i]) cnt++;
        }

        System.out.println(cnt);



    }
    static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if(this.start == o.start) {
                return this.end - o.end;
            } else {
                return this.start - o.start;
            }
        }
    }

}
