package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9934 {
    static int k;
    static int[] arr;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new int[(int)Math.pow(2, k) - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<arr.length ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[k];
        for(int i=0 ; i<k ; i++)
            list[i] = new ArrayList<>();

        recur(0, arr.length-1, 0);
        for(int i=0 ; i<k ; i++) {
            for(int num : list[i]) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    static void recur(int s, int e, int depth) {
        if(depth == k)
            return;

        int m = (s + e) / 2;

        list[depth].add(arr[m]);
        recur(s, m-1, depth+1);
        recur(m+1, e, depth+1);

    }
}
