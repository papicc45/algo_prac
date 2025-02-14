package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_25634 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] lights = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            lights[i] = Integer.parseInt(st.nextToken());


        int on = 0, off = 0;
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            int light = Integer.parseInt(st.nextToken());
            if(light == 0) {
                off += lights[i];

                if(lights[i] > off)
                    off = lights[i];

                if(off > max)
                    max = off;
            } else {
                on += lights[i];
                off -= lights[i];


                if(lights[i] * -1 > max)
                    max = lights[i] * -1;
            }
        }

        System.out.println(max + on);

    }
}
