package com.graph.dfs;

import java.util.ArrayList;

public class DFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void dfs(ArrayList<ArrayList<Integer>> graph, boolean visited[], int src) {
		if(visited[src]==true)	
			return;
		visited[src] = true;
		ArrayList<Integer> adj = graph.get(src);
		for(int i=0;i<adj.size();i++) {
			int node = adj.get(i);
			if(visited[node]==false)
				dfs(graph,visited,node);
		}
		
	}

}
