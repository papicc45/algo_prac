package slidingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[d+1];

        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(br.readLine());

        sushi[c]++;
        HashSet<Integer> set = new HashSet<>();
        set.add(c);
        for(int i=0 ; i<k ; k++) {
            sushi[arr[i]]++;
            set.add(arr[i]);
        }

        int result = set.size();
        for(int i=1 ; i<n ; i++) {

        }



    }
}
