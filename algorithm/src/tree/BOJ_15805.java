package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[200001];
        result[arr[0]] = -1;
        set.add(arr[0]);

        for(int i=1 ; i<n ; i++) {
            if(!set.contains(arr[i])) {
                result[arr[i]] = arr[i-1];
                set.add(arr[i]);
            }
        }

        System.out.println(set.size());
        for(int i=0 ; i<set.size() ; i++) {
            System.out.print(result[i] + " ");
        }


    }
}
