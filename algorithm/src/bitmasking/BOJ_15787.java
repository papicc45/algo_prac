package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15787 {
    static int n, m;
    static int[] trains;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trains = new int[n+1];

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            if(command == 1) {
                int seat = Integer.parseInt(st.nextToken()) - 1;
                trains[idx] |= (1 << seat);
            } else if(command == 2) {
                int seat = Integer.parseInt(st.nextToken()) - 1;
                trains[idx] &= ~(1 << seat);
            } else if(command == 3) {
                trains[idx] = (trains[idx] & ~(1 << 19)) << 1;
            } else {
                trains[idx] = (trains[idx] & ~(1 << 0)) >> 1;
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=1 ; i<=n ; i++)
            set.add(trains[i]);

        System.out.println(set.size());
    }
}
