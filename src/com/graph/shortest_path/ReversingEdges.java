package com.graph.shortest_path;

import java.util.*;

public class ReversingEdges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Pair{
		int destination;
		int weight;
		public Pair(int d, int w){
			this.destination= d;
			this.weight = w;
		}
	}
	public int reverseEdges(int n, int[][] B) {
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for(int i=0;i<=n;i++) {
			graph.add(i,new ArrayList<Pair>());
		}
		for(int i=0;i<B.length;i++) {
			int s = B[i][0];
			int d = B[i][1];
			graph.get(s).add(new Pair(d, 0));
            graph.get(d).add(new Pair(s, 1)); 
		}
        int res[] = new int[n+1];
		Arrays.fill(res, 100000);
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2)->o1.weight-o2.weight);
		
		
		res[1] = 0;
		pq.add(new Pair(1, 0));
		while(pq.size()>0) {
			Pair pair = pq.poll();
			int u  = pair.destination;
			int uw = pair.weight;
			if(uw == res[u]) {
				ArrayList<Pair> adj = graph.get(u);
				for(Pair p : adj) {
					int v = p.destination;
					int vw = p.weight;
					if(res[u]+vw < res[v]) {
						res[v] = res[u]+vw;
						pq.add(new Pair(v, res[v]));
					}
				}
			}
				
		}	
        for(int i=0;i<=n;i++){
            if(res[i]==100000)  res[i]=-1;
        }
		return res[n];
    }

}
