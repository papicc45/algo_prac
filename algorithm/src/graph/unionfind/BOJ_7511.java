package graph.unionfind;

import javax.sound.midi.VoiceStatus;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_7511 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int j=0 ; j<t ; j++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];

            for(int i=0 ; i<n ; i++)
                arr[i] = i;

            int k = Integer.parseInt(br.readLine());
            for(int i=0 ; i<k ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            sb.append("Scenario " + (j+1) + ":\n");
            int m = Integer.parseInt(br.readLine());
            for(int i=0 ; i<m ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = find(Integer.parseInt(st.nextToken()));
                int b = find(Integer.parseInt(st.nextToken()));

                if(a != b)
                    sb.append("0\n");
                else
                    sb.append("1\n");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    private static int find(int a) {
        if(arr[a] == a)
            return a;

        return arr[a] = find(arr[a]);
    }
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b)
            arr[b] = a;
    }
}
