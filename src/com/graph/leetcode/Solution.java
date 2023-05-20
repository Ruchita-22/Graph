package com.graph.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Pair{
		String d;
		double wt;
		
		public Pair(String d, double wt) {
			this.d = d;
			this.wt = wt;
		}
	}
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //graph construction
		HashMap<String, List<Pair>> graph = new HashMap<>();
        
		for(int i = 0; i < equations.size(); i++) {
			String s = equations.get(i).get(0);
			String d = equations.get(i).get(1);
			double val = values[i];
			
			graph.putIfAbsent(s, new ArrayList<>());
			graph.putIfAbsent(d, new ArrayList<>());
			
			graph.get(s).add(new Pair(d, val));
			graph.get(d).add(new Pair(s, 1/val));
			
		}
		double res[] = new double[queries.size()];
		
		// call dfs for each query
		for(int i = 0; i < queries.size() ; i++) {
			String s = queries.get(i).get(0);
			String d = queries.get(i).get(1);
			HashSet<String> visited = new HashSet<>();
			res[i] = dfs(s,d,graph,visited, 1.0);
		}
		
		return res;
		
    }
	private static double dfs(String s, String d, HashMap<String, List<Pair>> graph, HashSet<String> visited, double ans) {
        if( !graph.containsKey(s)) {
			return -1.0;
		}
		if(s.equals(d)) {
			return ans;
		}
        
		visited.add(s);
		for(Pair adj : graph.get(s)) {
			if(!visited.contains(adj.d)) {
				double tempAns = dfs(adj.d,d,graph,visited,adj.wt);
				if (tempAns != -1) return ans * tempAns;
			}
				
		}
		return -1.0;
	}
}
