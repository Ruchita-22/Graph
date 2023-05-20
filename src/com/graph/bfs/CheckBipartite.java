package com.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBipartite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int n, int[][] mat) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++)   graph.add(i,new ArrayList());
        for(int i=0;i<mat.length;i++){
            int s = mat[i][0];
            int d = mat[i][1];
            graph.get(s).add(d);
            graph.get(d).add(s);
        }
        int visited[] = new int[n+1];
        Arrays.fill(visited,0);
        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                if(!bfs(i,graph,visited))
                    return 0;
            }
        }
        return 1;
    }
    private static boolean bfs(int s,ArrayList<ArrayList<Integer>> graph, int visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = 1;
        while(q.size()>0){
            int node = q.poll();
            ArrayList<Integer> adj = graph.get(node);
            for(int i :  adj){
                if(visited[i]==0){
                    q.add(i);
                    visited[i] = -visited[node];
                }
                if(visited[i]==visited[node])   return false;
            }
        }
        return true;
    }

}
