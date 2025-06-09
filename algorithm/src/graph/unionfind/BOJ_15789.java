package graph.unionfind;

import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15789 {
    static int[] parent;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        cnt = new int[n+1];

        for(int i=1 ; i<=n ; i++)
            parent[i] = i;
        Arrays.fill(cnt, 1);

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)) {

                union(a, b);
            }
        }

        st = new StringTokenizer(br.readLine());
        int ctp = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int rootCTP = find(ctp);
        int rootC = find(c);

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=1 ; i<=n ; i++) {
            int r = find(i);
            map.put(r, cnt[r]);
        }

        map.remove(rootCTP);
        map.remove(rootC);

        List<Integer> list = new ArrayList<>(map.values());
        list.sort(Comparator.reverseOrder());

        int result = cnt[rootCTP];
        for(int i=0 ; i<Math.min(h, list.size()) ; i++) {
            result += list.get(i);
        }

        System.out.println(result);
    }

    private static int find(int a) {
        if(parent[a] == a)
            return a;

        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
            cnt[a] += cnt[b];
        }
    }
}
