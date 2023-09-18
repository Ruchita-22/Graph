package com.graph.mst;

import java.util.Arrays;

public class DisjointSet {
	int[] rank, size, parent;
	public DisjointSet(int n) {
		// TODO Auto-generated constructor stub
		parent = new int[n+1];
		// each node is parent of itself
		int parent[] = new int[n+1];
        for(int i=0;i<=n;i++)  
        	parent[i] = i; 
				
		rank = new int[n+1];
		Arrays.fill(rank, 0);
		size = new int[n+1];
		Arrays.fill(size, 0);
	}
	
	public int parentCompute(int n, int parent[]) {
		if(parent[n]==n)	return n;
		return parent[n] = parentCompute(parent[n], parent);	
	}
	
	public void unionByRank(int u, int v) {
		
		// find parent
		int pu = parentCompute(u,parent);
		int pv = parentCompute(v,parent);
		if(pu == pv)	return;
		else {
			if(rank[pu]< rank[pv]) {
				parent[pu] = pv;
			}
			else {
				parent[pv] = pu;
				rank[pu]++;
			}
		}
	}
	public void unionBySize(int u, int v) {
		
		// find parent
		int pu = parentCompute(u,parent);
		int pv = parentCompute(v,parent);
		if(pu == pv)	return;
		else {
			if(size[pu]< size[pv]) {
				parent[pu] = pv;
				size[pv] += size[pu];
			}
			else {
				parent[pv] = pu;
				size[pu] += size[pv];
			}
		}
	}
}
