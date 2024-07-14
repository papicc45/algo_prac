package search.dfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16437 {
    static int n;
    static ArrayList<Integer>[] list;
    static int[] amount;
    static long[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        for(int i=0 ; i<=n ; i++)
            list[i] = new ArrayList<>();
        amount =  new int[n+1];
        result = new long[n+1];
        for(int i=2 ; i<=n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int am = Integer.parseInt(st.nextToken());
            list[Integer.parseInt(st.nextToken())].add(i);
            if(s.equals("W")) {
                am *= -1;
            }

            result[i] = am;
        }
        dfs(1, -1);
        System.out.println(result[1]);

    }
    private static void dfs(int idx, int bef) {
        for(int next : list[idx]) {
            dfs(next, idx);
        }

        if(bef != -1) {
            if(result[idx] > 0) {
                result[bef] += result[idx];
            }
        }
    }
}
