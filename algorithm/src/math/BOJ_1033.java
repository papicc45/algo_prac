package math;

import java.io.*;
import java.util.*;

public class BOJ_1033 {
    static ArrayList<Integer>[] A;
    static boolean []visited;
    static long []values;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        for (int i = 0; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }
        values = new long[N+1];
        visited = new boolean[N+1];

        for(int i = 0; i<=N; i++) {
            values[i] = 1;
        }

        for(int i = 1; i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long p = Integer.parseInt(st.nextToken());
            long q = Integer.parseInt(st.nextToken());
            long gcd;

            if (p>q) {
                gcd = gcd(p,q);
            }
            else {
                gcd = gcd(q,p);
            }

            p = p/gcd;
            q = q/gcd;


            if (values[b] != 1 || values[a] != 1) {

                long valuesa;
                long valuesb;

                valuesa = values[b] * p;
                valuesb = values[a] * q;

                if (valuesa>valuesb) {
                    gcd = gcd(valuesa,valuesb);
                    valuesa = valuesa/gcd;
                    valuesb = valuesb/gcd;


                }
                else {
                    gcd = gcd(valuesb,valuesa);
                    valuesa = valuesa/gcd;
                    valuesb = valuesb/gcd;

                }

                values[a] = values[a]*valuesa;
                values[b] = values[b]*valuesb;


                DFS(a,valuesa);
                init();
                DFS(b,valuesb);
                init();
            }
            else {
                values[a] = values[a]*p;
                values[b] = values[b]*q;

                DFS(a,p);
                init();
                DFS(b,q);
                init();
            }

            A[a].add(b);
            A[b].add(a);
        }


        for (int i = 0; i<N; i++) {
            System.out.print(values[i]+" ");
        }
    }
    public static void DFS(int num, long mulval) {
        visited[num] = true;
        for (int i:A[num]) {
            if(!visited[i]) {
                values[i] = values[i] * mulval;
                DFS(i,mulval);
            }
        }
    }

    static void init() {
        for (int i = 0; i<=N; i++) {
            visited[i] = false;
        }
    }
    static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}