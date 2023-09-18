package com.graph.bfs;

import java.util.*;

public class DistanceToNearestCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Pair{
	    int x;
	    int y;
	    public Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	public int[][] solve(int[][] mat) {
		
        int n = mat.length;
        int m = mat[0].length;
        int res[][] = new int[n][m];
        for(int t[] : res)  Arrays.fill(t, 100000000);
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1){
                    res[i][j] = 0;
                    q.add(new Pair(i,j));
                }        
            }
        }
        int dx[] = new int[]{-1,+1,0,0};
        int dy[] = new int[]{0,0,-1,1};
        while(q.size()>0){
            Pair p = q.poll();
           
            for(int i=0;i<4;i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(isValid(x,y,n,m)){
                    if(res[x][y]> 1 + res[p.x][p.y]){
                        q.add(new Pair(x,y));
                        res[x][y]= 1+ res[p.x][p.y];
                    }
                }
            }
        }
        return res;
    }
    private static boolean isValid(int x, int y, int n, int m){
        if(x<0 || x>=n || y<0 || y>=m)  return false;
        else return true;
    }

}
