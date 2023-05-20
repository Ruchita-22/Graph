package com.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathInDircetedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int n, int[][] mat) {
        ArrayList<ArrayList<Integer>> graph = constDirectedGraph(n,mat);
        return bfs(1,n, graph) ? 1 : 0;
    }
    private static ArrayList<ArrayList<Integer>> constDirectedGraph(int n, int[][] mat){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            graph.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<mat.length;i++){
            int s = mat[i][0];
            int d = mat[i][1];
            ArrayList<Integer> list = graph.get(s);
            list.add(d);  
        }
        return graph;
    }
    private static boolean bfs(int s, int d, ArrayList<ArrayList<Integer>> graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.size()];
        Arrays.fill(visited,false);

        q.add(s);
        visited[s] = true;
        while(q.size()>0){
            Integer n = q.poll();
            ArrayList<Integer> adj = graph.get(n);
            for(Integer i : adj){
                if(visited[i]==false){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return visited[d];
    }

}
