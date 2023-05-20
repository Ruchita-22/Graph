package com.graph.topological_sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Possibility_of_Finishing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int courses[][] = new int[][] {{100,200},{200,1300},{1000,1250},{2000,3200}};
	}
	
	//207. Course Schedule
	//
	public int solve(int n, int[] U, int[] V) {
        int inDegree[] = new int[n+1];
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            graph.add(i,new ArrayList<Integer>());
        }
        for(int i=0;i<U.length;i++){
            int s = U[i];
            int d = V[i];
            graph.get(s).add(d);  
            inDegree[d]++;
        }
		PriorityQueue<Integer> q = new PriorityQueue<>();
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
        return list.size()==n ? 1 : 0;
    }

}
