package com.graph.mst;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MakeLargerIsland {

	public MakeLargerIsland(int grid[][]) {
		// TODO Auto-generated constructor stub
		int n = grid.length;
		int m = grid[0].length;
		DisjointSet ds = new DisjointSet(n*m);
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == 0) continue;
				int dx[] = new int[] {-1,1,0,0};
				int dy[] = new int[] {0,0,-1,1}; 
				for (int i = 0; i < 4; i++) {
					int x = row + dx[i];
					int y = col + dy[i];
					if(isValid(x, y, n, m) && grid[x][y] == 1) {
						int nodeNo = row * n + col;
						int newNodeNo = x * n + y;
								ds.unionBySize(nodeNo, newNodeNo);
						
					}
					
				}
			}
		}
		int mx = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if(grid[row][col] == 1) continue;
				int dx[] = new int[] {-1,1,0,0};
				int dy[] = new int[] {0,0,-1,1}; 
				Set<Integer> component = new HashSet<>();
				for (int i = 0; i < 4; i++) {
					int x = row + dx[i];
					int y = col + dy[i];
					if(isValid(x, y, n, m) && grid[x][y] == 1) {
						int newNodeNo = x * n + y;
						component.add(ds.parentCompute(newNodeNo, ds.parent));
						
					}
					
				}
				int sizeTotal = 0;
				for(int e : component) {
					sizeTotal += ds.size[e];
				}
				mx = Math.max(mx, sizeTotal);
			}
		}

		
	}
	private static boolean isValid(int i, int j, int n, int m) {
    	if(i < 0 || i >= n || j < 0 || j >= m ) return false;
    	else return true;
    }

}
