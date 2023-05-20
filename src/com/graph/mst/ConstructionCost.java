package com.graph.mst;

import java.util.Arrays;

public class ConstructionCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Krushkal algo
	//Q3. Construction Cost
	//Q2. Commutable Islands
	public int solve(int n, int[][] edges) {
		//sort edges by weight
        Arrays.sort(edges,(o1,o2)->o1[2]-o2[2]);
        
        //each node is a parent of itself
        int parent[] = new int[n+1];
        for(int i=0;i<=n;i++)  
            parent[i] = i; 

        long cost = 0;
        for(int i=0;i<edges.length;i++) {
			int u = edges[i][0];
            int v = edges[i][1];
			int pu = parentCompute(u,parent);
			int pv = parentCompute(v,parent);
			if(pu != pv) {
                cost += edges[i][2];
				parent[Math.max(pu, pv)] = Math.min(pu, pv);
			}
			
		}
        int mod = (int)(1e9+7);
        return (int)(cost % mod);    
		
    }

    private static int parentCompute(int n, int parent[]) {
		if(parent[n]==n)	return n;
		return parent[n] = parentCompute(parent[n], parent);	
	}

}
