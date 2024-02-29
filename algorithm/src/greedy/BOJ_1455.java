package greedy;

import java.beans.beancontext.BeanContextServiceProviderBeanInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1455 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o2[1] - o1[1];
                else
                    return o2[0] - o1[0];
            }
        });
        boolean[][] visited = new boolean[n][m];
        int nx = 0, ny = 0;
        for(int i=0 ; i<n ; i++) {
            String[] temp = br.readLine().split("");
            for(int j=0 ; j<m ; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
                if(arr[i][j] == 1) {
                    nx = i;
                    ny = j;
                }
            }
        }
        queue.add(new int[] {nx, ny});
        int result = 0;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            if(!visited[x][y]) {
                result++;
                visited[x][y] = true;
                for(int i=0 ; i<=x ; i++) {
                    for(int j=0 ; j<=y ; j++) {
                        arr[i][j] = arr[i][j] == 0 ? 1 : 0;
                        if(arr[i][j] == 1)
                            queue.add(new int[] {i, j});
                    }
                }
            }
        }
        System.out.println(result);
    }
}
