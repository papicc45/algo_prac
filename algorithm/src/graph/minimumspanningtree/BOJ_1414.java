package graph.minimumspanningtree;

import jdk.dynalink.linker.support.SimpleLinkRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1414 {
    static int[] arr;
    static ArrayList<Cable> list = new ArrayList<>();
    static ArrayList<Cable> selfConnect = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 소문자 : - '0' - 48
        // 대문자 : - '0' + 10
        int n = Integer.parseInt(br.readLine());
        int sumLen = 0;
        for(int i=1 ; i<=n ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<str.length() ; j++) {
                char ch = str.charAt(j);
                if(ch == '0')
                    continue;
                int len = 0;
                if(i == j+1) {
                    int start = i, end = i;
                    len = getLen(ch);
                    selfConnect.add(new Cable(start, end, len));
                } else {
                    int start = i;
                    int end = j+1;
                    len = getLen(ch);
                    list.add(new Cable(start, end, len));
                }
                sumLen += len;
            }
        }

        arr = new int[n+1];
        for(int i=1 ; i<=n ; i++) {
            arr[i] = i;
        }
        boolean[] isConnected = new boolean[n+1];
        int minLen = 0;
        Collections.sort(list);
        for(int i=0 ; i<n-1 ; i++) {
            Cable temp = list.get(i);

            int a = find(temp.start);
            int b = find(temp.end);

            if(a != b) {
                union(a, b);
                minLen += temp.len;
                isConnected[a] = true;
                isConnected[b] = true;

            }
        }

        boolean check = false;
        ArrayList<Integer> notConnectList = new ArrayList<>();
        for(int i=1 ; i<=n ; i++) {
            if(!isConnected[i]) {
                check = true;
                notConnectList.add(i);
            }
        }
        sumLen -= minLen;
        if(!check) {
            System.out.println(sumLen);
        } else {
            for(int i=0 ; i<notConnectList.size() ; i++) {
                for(Cable cable : selfConnect) {
                    if(notConnectList.get(i) == cable.start) {
                        isConnected[i] = true;
                        sumLen -= cable.len;
                    }
                }
            }
            for(int i=0 ; i<notConnectList.size() ; i++) {
                if(!isConnected[i]) {
                    System.out.println("-1");
                    return;
                }
            }
            System.out.println(sumLen);
        }
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
    private static int getLen(char ch) {
        if(ch >= 'a' && ch <= 'z') {
            return ch - '0' - 48;
        } else {
            return ch - '0' + 10;
        }
    }
    static class Cable implements Comparable<Cable>{
        int start;
        int end;
        int len;

        public Cable(int start, int end, int len) {
            this.start = start;
            this.end = end;
            this.len = len;
        }

        @Override
        public int compareTo(Cable o) {
            return this.len - o.len;
        }
    }
}
