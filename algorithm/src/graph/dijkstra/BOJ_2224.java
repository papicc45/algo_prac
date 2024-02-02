package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.util.*;

public class BOJ_2224 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] floyd = new int[58][58];

        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            char[] arr = br.readLine().toCharArray();
            //왼쪽 - 0번째, 오른쪽 - 5번째
            int left = arr[0] - 'A';
            int right = arr[5]- 'A';
            if(left != right) {
                floyd[left][right] = 1;
                result.add(new int[] {left, right});
            }
        }

        for(int k=0 ; k<58 ; k++) {
            for(int i=0 ; i<58 ; i++) {
                for(int j=0 ; j<58 ; j++) {
                    if(i == j || i == k || j == k || floyd[i][j] == 1)
                        continue;
                    if(floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0 ; i<58 ; i++) {
            for(int j=0 ; j<58 ; j++) {
                if(i == j || floyd[i][j] == 0)
                    continue;
                count++;
                sb.append((char)(i + 'A')).append(" => ").append((char)(j + 'A')).append("\n");
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
