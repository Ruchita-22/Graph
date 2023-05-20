package com.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void constDirctedGraph(int arr[][]) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			int src = arr[i][0];
			int des = arr[i][1];
			
			//src to des
			if(!graph.contains(src))	graph.add(src,new ArrayList<>());
			graph.get(src).add(des);
		}
		
	}
	private static void constUndirctedGraph(int arr[][]) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			int src = arr[i][0];
			int des = arr[i][1];
			
			//src to des
			if(!graph.contains(src))	graph.add(src,new ArrayList<>());
			graph.get(src).add(des);
			
			//des to src
			if(!graph.contains(des))	graph.add(des,new ArrayList<>());
			graph.get(des).add(src);
		}
		
	}
	private static boolean bfs(ArrayList<ArrayList<Integer>> graph, int src, int des) {
		boolean visited[] =  new boolean[graph.size()+1];
		Arrays.fill(visited, false);
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		visited[src] = true;
		while(q.size()>0) {
			int n = q.poll();
			ArrayList<Integer> adj = graph.get(n);
			for(int i : adj) {
				if(visited[i]==false) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		return visited[des];
	}

}
