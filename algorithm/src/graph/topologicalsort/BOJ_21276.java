package graph.topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.*;

public class BOJ_21276 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedHashMap<String, Integer> strMap = new LinkedHashMap<>();
        HashMap<Integer, String> intMap = new HashMap<>();
//        List<Person> list = new ArrayList<>();
        List<Integer>[] list = new ArrayList[n];
        List<String>[] answer = new ArrayList[n];
        for(int i=0 ; i<n ; i++) {
            list[i] = new ArrayList<>();
            answer[i] = new ArrayList<>();
        }

        for(int i=0 ; i<n ; i++) {
            String name = st.nextToken();
            strMap.put(name, i);
            intMap.put(i, name);
        }

        int m = Integer.parseInt(br.readLine());
        int[] degree = new int[n];
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            String p1 = st.nextToken();
            String p2 = st.nextToken();

            list[strMap.get(p1)].add(strMap.get(p2));
            degree[strMap.get(p2)]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<n ; i++) {
            if(degree[i] == 0)
                queue.add(i);
        }
        List<String> top = new ArrayList<>();
        int cnt = 0;
        while(!queue.isEmpty()) {
            int temp = queue.poll();

            if(list[temp].size() == 0) {
                top.add(intMap.get(temp));
                cnt++;
            }

            for(Integer next : list[temp]) {
                degree[next]--;

                answer[next].add(intMap.get(temp));

                if(degree[next] == 0)
                    queue.add(next);
            }
        }
        Collections.sort(top);
        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");

        for(int i=0 ; i<n ; i++) {
            System.out.print(intMap.get(i) + " ");
            System.out.print(answer[i].size() + " ");
            for(String p : answer[i]) {
                System.out.print(p + " ");
            }
            System.out.println();
        }


    }
}
