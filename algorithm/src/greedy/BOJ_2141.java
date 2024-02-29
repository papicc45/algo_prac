package greedy;

import java.util.*;
import java.io.*;

public class BOJ_2141 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        long sum = 0;
        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            arr[i][0] = index;
            arr[i][1] = people;
            sum += people;
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return  o1[0] - o2[0];
            }
        });

        long temp = 0;
        for(int i=0 ; i<n ; i++) {
            temp += arr[i][1];
            if((sum+1) / 2 <= temp) {
                System.out.println(arr[i][0]);
                return;
            }
        }
    }
}

