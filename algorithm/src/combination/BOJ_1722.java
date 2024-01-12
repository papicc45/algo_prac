package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1722 {
    static int n;
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int problem = Integer.parseInt(st.nextToken());

        int factorial = 1;
        for(int i=1 ; i<=n ; i++) {
            factorial *= i;
        }

        for(int i=1 ; i<=n ; i++) {
            visited = new boolean[n+1];
            DFS(i, 1, String.valueOf(i));
        }
        if(problem == 1) {
            int th = Integer.parseInt(st.nextToken());
            String str = list.get(th - 1);
            for(int i=0 ; i<str.length() ; i++) {
                System.out.print(str.charAt(i) + " ");
            }
        } else {
            String str = "";
            for(int i=0 ; i<n ; i++) {
                str += st.nextToken();
            }
            for(int i=0 ; i<list.size() ; i++) {
                if(list.get(i).equals(str)) {
                    System.out.println(i + 1);
                    return;
                }
            }
        }
    }
    private static void DFS(int num, int count, String temp) {
        if(count == n) {
            list.add(temp);
            return;
        }

        visited[num] = true;
        for(int i=1 ; i<=n ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                DFS(i, count + 1, temp + i);
                visited[i] = false;
            }
        }
    }
}
