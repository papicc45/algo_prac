package simulation;

import java.beans.beancontext.BeanContextServiceProviderBeanInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.util.StringTokenizer;

public class BOJ_21922 {
    static int[][] arr;
    static boolean[][] visited;
    static int n, m;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(arr[i][j] == 9) {
                    search(i, j);
                }
            }
        }
        System.out.println(result);
    }
    private static void search(int x, int y) {
        up(x, y);
        down(x, y);
        right(x, y);
        left(x, y);
    }
    private static void up(int x, int y) {
        if(!check(x, y))
            return;

        boolean stuff = false;
        while (x >= 0) {
            if(!visited[x][y]) {
                visited[x][y] = true;
                result++;
                if(arr[x][y] == 2 || arr[x][y] == 3 || arr[x][y] == 4) {
                    stuff = true;
                    break;
                }
            } else {
                if(arr[x][y] == 2 || arr[x][y] == 3 || arr[x][y] == 4) {
                    break;
                }
            }
            x--;
        }

        if(stuff) {
            if(arr[x][y] == 2) {
                down(x-1, y);
            } else if(arr[x][y] == 3) {
                right(x, y+1);
            } else if(arr[x][y] == 4) {
                left(x, y-1);
            }
        }
    }
    private static void down(int x, int y) {
        if(!check(x, y))
            return;

        boolean stuff = false;
        while (x < n) {
            if(!visited[x][y]) {
                visited[x][y] = true;
                result++;
                if(arr[x][y] == 2 || arr[x][y] == 3 || arr[x][y] == 4) {
                    stuff = true;
                    break;
                }
            } else {
                if(arr[x][y] == 2 || arr[x][y] == 3 || arr[x][y] == 4) {
                    break;
                }
            }
            x++;
        }

        if(stuff) {
            if(arr[x][y] == 2) {
                up(x-1, y);
            } else if(arr[x][y] == 3) {
                left(x, y-1);
            } else if(arr[x][y] == 4) {
                right(x, y+1);
            }
        }
    }
    private static void left(int x, int y) {
        if(!check(x, y))
            return;

        boolean stuff = false;
        while (y >= 0) {
            if(!visited[x][y]) {
                visited[x][y] = true;
                result++;
                if(arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 4) {
                    stuff = true;
                    break;
                }
            }  else {
                if(arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 4) {
                    break;
                }
            }
            y--;
        }

        if(stuff) {
            if(arr[x][y] == 1) {
                right(x, y+1);
            } else if(arr[x][y] == 3) {
                down(x+1, y);
            } else if(arr[x][y] == 4) {
                up(x-1, y);
            }
        }
    }
    private static void right(int x, int y) {
        if(!check(x, y))
            return;

        boolean stuff = false;
        while (y < m) {
            if(!visited[x][y]) {
                    visited[x][y] = true;
                    result++;
                if(arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 4) {
                    stuff = true;
                    break;
                }
            }  else {
                if(arr[x][y] == 1 || arr[x][y] == 3 || arr[x][y] == 4) {
                    break;
                }
            }
            y++;
        }

        if(stuff) {
            if(arr[x][y] == 1) {
                left(x, y-1);
            } else if(arr[x][y] == 3) {
                up(x-1, y);
            } else if(arr[x][y] == 4) {
                down(x+1, y);
            }
        }
    }
    private static boolean check(int x, int y) {
        if(x<0 || y<0 || x>=n || y>=m) return false;
        else return true;
    }
}
