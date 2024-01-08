package graph.bellmanford;

import java.awt.image.DataBufferUShort;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11657 {


    static long[] distance;
    static Bus[] buses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        buses = new Bus[m];
        distance = new long[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0 ; i<m ; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            buses[i] = new Bus(start, end, value);
        }

        distance[1] = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                Bus bus = buses[j];

                if(distance[bus.start] != Integer.MAX_VALUE && distance[bus.end] > distance[bus.start] + bus.value) {
                    distance[bus.end] = distance[bus.start] + bus.value;
                }
            }
        }

        boolean isCycle = false;
        for(int i=0 ; i<m ; i++) {
            Bus bus = buses[i];

            if(distance[bus.start] != Integer.MAX_VALUE && distance[bus.end] > distance[bus.start] + bus.value) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle) {
            for(int i=2 ; i<=n ; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println("-1");
        }
    }
}

class Bus {
    int start;
    int end;
    int value;

    public Bus(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}