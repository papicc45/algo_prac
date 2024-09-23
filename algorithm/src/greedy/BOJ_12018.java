package greedy;

import javax.naming.ServiceUnavailableException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_12018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Subject> list = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            int[] arr = new int[p];
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<p ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            list.add(new Subject(p,l,arr));
        }

        int[] result = new int[n];
        for(int i=0 ; i<list.size() ; i++) {
            Subject subject = list.get(i);
            int[] arr = subject.ms;
            Arrays.sort(arr);
            if(arr.length < subject.l) {
                result[i] = 1;
            } else {
                int idx = (subject.p-1) - (subject.l - 1);
                result[i] = arr[idx];
            }
        }
        Arrays.sort(result);
        int sum = 0;
        int cnt = 0;
        for(int i=0 ; i<n ; i++) {
            sum += result[i];
            if(sum > m)
                break;

            cnt++;
        }
        System.out.println(cnt);
    }
    static class Subject {
        int p;
        int l;
        int[] ms;

        public Subject(int p, int l, int[] ms) {
            this.p = p;
            this.l = l;
            this.ms = ms;
        }

    }
}
