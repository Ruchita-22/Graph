package com.graph.dfs;

import java.util.*;

public class Batches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int n, int[] strength, int[][] mat, int threshold) {
        //graph construction
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
        // dfs call
        boolean visited[] = new boolean[n+1];
        Arrays.fill(visited,false);
        
        int count = 0;
        for(int i=1;i<=n;i++){
            if(visited[i]==false){
                int t = 0;
                t = dfs(i,graph,visited,strength);
                if(t>=threshold) count++;
            }
        }
        return count;
    }
    private static int dfs(int s,ArrayList<ArrayList<Integer>> graph, boolean visited[], int[] strength){
        if(visited[s]==true)    return 0;	//already visited node

        visited[s] = true;
        int temp = strength[s-1];
        
        ArrayList<Integer> adj = graph.get(s);
        for(int i=0;i<adj.size();i++){
            int node = adj.get(i);
            if(visited[node]==false)
                temp += dfs(node,graph,visited,strength);
        }
        return temp;
    }

}
