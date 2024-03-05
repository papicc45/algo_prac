package graph.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        for(int i=0 ; i<k ; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            arr[front][back] = 1;
            arr[back][front] = -1;
        }

        for(int t=1 ; t<=n ; t++) {
            for(int i=1 ; i<=n ; i++) {
                for(int j=1 ; j<=n ; j++) {
                    if(arr[i][t] == 1 && arr[t][j] == 1) {
                        arr[i][j] = 1;
                    } else if(arr[i][t] == -1 && arr[t][j] == -1) {
                        arr[i][j] = -1;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        for(int i=0 ; i<s ; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            if(arr[front][back] == 1) {
                System.out.println("-1");
            } else if(arr[front][back] == -1) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }

        }
    }
}
