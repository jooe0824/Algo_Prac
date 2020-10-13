package BfsDfs;

import java.util.*;

public class DfsSearch {
    static boolean[] visited;
    static ArrayList<Integer>[] a;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        visited = new boolean[num+1];

        a = (ArrayList<Integer>[]) new ArrayList[num+1];

        for(int i=0; i<=num; i++){
            a[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }

        for(int i=0;i<=num;i++){
            Collections.sort(a[i]);
        }

        dfs(start);
        System.out.println();

        visited = new boolean[num+1];
        bfs(start);
        System.out.println();
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int x = q.remove();
            System.out.print(x + " ");
            for(int y: a[x]) {
                if (!visited[y]) {
                    visited[y] = true;

                    q.add(y);
                }
            }
        }
    }
    public static void dfs(int x){
        if(visited[x]){
            return;
        }
        visited[x] = true;
        System.out.print(x+" ");
        for(int y : a[x]){
            if(!visited[y]){
                dfs(y);
            }
        }
    }
}
