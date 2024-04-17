package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];
        for(int i=1 ; i<=n ; i++) {
            Arrays.fill(arr[i], 987654321);
            arr[i][i] = 0;
        }
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            arr[start][end] = length;
        }

        for(int k=1 ; k<=n ; k++) {
            for(int i=1; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        int k = Integer.parseInt(br.readLine());
        int[] person = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<k ; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }

        int[] max = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            for(int j=0 ; j<k ; j++) {
                max[i] = Math.max(max[i], arr[i][person[j]] + arr[person[j]][i]);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i=1 ; i<=n ; i++) {
            if(min > max[i]) {
                min = max[i];
                result.clear();
                result.add(i);
            } else if(min == max[i]) {
                result.add(i);
            }
        }

        for(Integer i : result) {
            System.out.print(i + " ");
        }
    }
}
