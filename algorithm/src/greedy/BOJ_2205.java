package greedy;

import java.beans.Visibility;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_2205 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        int a = 2;
        while (a <= 20000) {
            set.add(a);
            a *= 2;
        }

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for(int i=n ; i>=1 ; i--) {
            for(int j=1 ; j<=n ; j++) {
                if(set.contains(i + j) && !visited[j] && !visited[i]) {
                    arr[i] = j;
                    arr[j] = i;
                    visited[i] = true;
                    visited[j] = true;
                    break;
                }
            }
        }

        for(int i=1 ; i<=n ; i++) {
            System.out.println(arr[i]);
        }
    }
}
