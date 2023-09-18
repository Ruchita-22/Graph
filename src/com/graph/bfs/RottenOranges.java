package com.graph.bfs;

import java.util.*;

public class RottenOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Pair{
	    int x,y;
	    public Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	public int solve(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<Pair> q = new LinkedList<>();
        //find rotten orange and then start
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==2){    
                    q.add(new Pair(i,j));
                    mat[i][j] = -1; //visited
                }    
            }
        }
        
        // BFS
        int dx[] = new int[]{-1,0,1,0};
        int dy[] = new int[]{0,1,0,-1};

        int time[][] = new int[n][m] ;
        
        while(q.size()>0){
            Pair p = q.poll();

            for(int i=0;i<4;i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];

                if(isValid(x,y,n,m) && mat[x][y]==1){
                    q.add(new Pair(x,y));
                    mat[x][y] = -1; 
                    time[x][y] = 1 + time[p.x][p.y];
                }
            }
        }
        // calculate max time
        int maxTime = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1)    return -1;
                maxTime = Math.max(maxTime, time[i][j]);
            }
        }
        return maxTime;
    }

    private static boolean isValid(int i, int j,int n, int m){
        if(i<0 || i>=n || j<0 || j>=m) return false;
        else return true;
    }

}
