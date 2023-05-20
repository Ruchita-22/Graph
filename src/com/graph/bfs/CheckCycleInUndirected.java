package com.graph.bfs;

import java.util.*;

public class CheckCycleInUndirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int n, int[][] mat) {
        //graph construction
        ArrayList<ArrayList<Integer>> graph = constUndirectedGraph(n,mat);
        boolean visited[] = new boolean[n+1];
        int component = 0;
        Arrays.fill(visited,false);
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                bfs(i,graph,visited);
                component++;
            }
        }
        int edges = mat.length;
        if(edges <= (n-component))   return 0;
        else return 1;
    }
    private static ArrayList<ArrayList<Integer>> constUndirectedGraph(int n, int[][] mat){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(i,new ArrayList<>());
        }
        for(int i=0;i<mat.length;i++){
            int s = mat[i][0];
            int d = mat[i][1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        return graph;
    }
    private static void bfs(int s,ArrayList<ArrayList<Integer>> graph,  boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while(q.size()>0){
            int node = q.poll();
            ArrayList<Integer> adj = graph.get(node);
            for(int i : adj){
                if(visited[i]==false){
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

}
