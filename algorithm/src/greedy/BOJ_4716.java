package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ConnectionBuilder;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4716 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Team[] teams = new Team[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int da = Integer.parseInt(st.nextToken());
            int db = Integer.parseInt(st.nextToken());
            teams[i] = new Team(k, da, db);
        }
        st = new StringTokenizer(br.readLine());

        Arrays.sort(teams);
        long result = 0;
        for(int i = 0; i < n; i++) {
            Team team = teams[i];
            if(team.da < team.db) {
                if(a - team.k < 0) {
                    result += (a * team.da);
                    team.k -= a;
                    a = 0;
                    result += team.k * team.db;
                    b -= team.k;
                } else {
                    result += (team.k * team.da);
                    a -= team.k;
                }
            } else  {
                if(b - team.k < 0) {
                    result += (b * team.db);
                    team.k -= b;
                    b = 0;
                    result += team.k * team.da;
                    a -= team.k;
                } else {
                    result += (team.k * team.db);
                    b -= team.k;
                }
            }
        }
        System.out.println(result);
    }
    static class Team implements Comparable<Team> {
        int k;
        int da;
        int db;

        public Team(int k, int da, int db) {
            this.k = k;
            this.da = da;
            this.db = db;
        }

        @Override
        public int compareTo(Team o) {
            return Math.abs(o.da - o.db) - Math.abs(this.da - this.db);
        }
    }
}
