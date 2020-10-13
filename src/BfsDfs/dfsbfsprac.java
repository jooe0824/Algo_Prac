package BfsDfs;

import java.util.*;

public class dfsbfsprac {
    static ArrayList<Integer>[] a;
    static boolean[] c;
    public static void dfs(int x) {
        if(c[x]){
            return;
        }
        c[x] = true;
        System.out.print(x+" ");
        for(int y : a[x]){
            if(!c[y]){
                dfs(y);
            }
        }
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        c[start] = true;
        while(!q.isEmpty()){
            int x = q.remove();
            System.out.print(x+" ");
            for(int y : a[x]){
                if(!c[y]){
                    c[y]=true;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        a = (ArrayList<Integer>[]) new  ArrayList[n+1];

//        ArrayList<Integer> b = new ArrayList<Integer>();
        for (int i =0;i<=n;i++){
            a[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u); //방향성 있는 간선일 경우
        }
        for(int i=0;i<=n;i++){
            Collections.sort(a[i]);
        }
        c= new boolean[n+1];
        bfs(start);
        System.out.println();
        c= new boolean[n+1];
        dfs(start);
        System.out.println();

    }
}