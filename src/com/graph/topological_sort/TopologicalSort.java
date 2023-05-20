package com.graph.topological_sort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static int[] solve(int n,int mat[][]) {
		
		//graph creation and set indegree
		
		int inDegree[] = new int[n+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		
        for(int i=0;i<=n;i++){
            graph.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<mat.length;i++){
            int s = mat[i][0];
            int d = mat[i][1];
            graph.get(s).add(d);  
            inDegree[d]++;
        }
        
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(inDegree[i]==0)	q.add(i);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		while(q.size()>0) {
			int node = q.poll();
			list.add(node);
			ArrayList<Integer> adj = graph.get(node);
			for(int i : adj) {
				inDegree[i]--;
				if(inDegree[i]==0)	q.add(i);
			}
		}
        return list.stream().mapToInt(Integer :: intValue).toArray();
		
	}
	//if you have to sort in lexigraphical then change queue with priority queue
}
