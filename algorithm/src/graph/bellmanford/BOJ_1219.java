package graph.bellmanford;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.DirectoryStream;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

public class BOJ_1219 {

    static Behicle[] behicles;
    static long[] totalMoney;

    static int[] getMoney;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int startDosi = Integer.parseInt(st.nextToken());
        int endDosi = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        behicles = new Behicle[m];
        totalMoney = new long[n];
        getMoney = new int[n];

        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            behicles[i] = new Behicle(start, end, value);
        }

        Arrays.fill(totalMoney, Long.MIN_VALUE);

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            getMoney[i] = Integer.parseInt(st.nextToken());
        }
        totalMoney[startDosi] = getMoney[startDosi];

        for(int i=0 ; i<n+100 ; i++) {
            for(int j=0 ; j<m ; j++) {
                int start = behicles[j].start;
                int end = behicles[j].end;
                int value = behicles[j].value;

                if(totalMoney[start] == Long.MIN_VALUE)
                    continue;
                else if(totalMoney[start] == Long.MAX_VALUE)
                    totalMoney[end] = Long.MAX_VALUE;
                else if(totalMoney[end] < totalMoney[start] + getMoney[end] - value) {
                    totalMoney[end] = totalMoney[start] + getMoney[end] - value;

                    if(i >= n-1)
                        totalMoney[end] = Long.MAX_VALUE;
                }

            }
        }

        if(totalMoney[endDosi] == Long.MIN_VALUE)
            System.out.println("gg");
        else if(totalMoney[endDosi] == Long.MAX_VALUE)
            System.out.println("Gee");
        else
            System.out.println(totalMoney[endDosi]);
    }
}

class Behicle {
    int start;
    int end;
    int value;

    public Behicle(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
