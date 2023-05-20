package com.graph.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;



public class UnionFindAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	// Union Find Algorithm
	public int[] solve(int n, int[][] edges) {
        
		// track of edge index
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            String key = edges[i][0]+"-"+edges[i][1]+"-"+edges[i][2];
            map.put(key,i);
        }
        
        // sort array by weight
        Arrays.sort(edges,(o1,o2)->o1[2]-o2[2]);
        
		// each node is parent of itself
		int parent[] = new int[n+1];
        for(int i=0;i<=n;i++)  
            parent[i] = i; 
		
        int res[] = new int[edges.length];
        Arrays.fill(res,0);
        
		for(int i=0;i<edges.length;i++) {
            int j=i;
            while(j<edges.length && edges[i][2]==edges[j][2]){
                int u = edges[j][0];
                int v = edges[j][1];
                int pu = parentCompute(u,parent);
			    int pv = parentCompute(v,parent);
                if(pu != pv){
                    String key = edges[j][0]+"-"+edges[j][1]+"-"+edges[j][2];
                    int index = map.get(key);
                    res[index] = 1;
                }
                j++;
            }
            
            j=i;
            while(j<edges.length && edges[i][2]==edges[j][2]){
                int u = edges[j][0];
                int v = edges[j][1];
                int pu = parentCompute(u,parent);
			    int pv = parentCompute(v,parent);
                if(pu != pv){
                    parent[Math.max(pu, pv)] = Math.min(pu, pv);
                }
                j++;
            }

			i=j-1;	
		}
		return res;
    }
    private static int parentCompute(int n, int parent[]) {
		if(parent[n]==n)	return n;
		return parent[n] = parentCompute(parent[n], parent);	
	}

}
