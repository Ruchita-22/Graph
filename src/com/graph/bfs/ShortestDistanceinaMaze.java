package com.graph.bfs;

import java.util.*;

public class ShortestDistanceinaMaze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// mat[i][j] = 0 empty
	// mat[i][j] = 1 wall
	class Pair{
	    int x,y,dir;
	    public Pair(int x, int y, int dir){
	        this.x = x;
	        this.y = y;
	        this.dir = dir;
	    }
	}
	public int solve(int[][] mat, int[] s, int[] d) {
        int n = mat.length;
        int m = mat[0].length;
        // initialise dist
        int dist[][][] = new int[n][m][4];
        for (int t[][] : dist)    
           for(int t1[] : t)
               Arrays.fill(t1, 1000000000);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(s[0],s[1],4));
        //visited in all dir is 0
        for(int i=0;i<4;i++){
            dist[s[0]][s[1]][i] = 0;
        }
  
        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,-1,1};
        
        while(q.size()>0){
            Pair p = q.poll();
            int dir = p.dir;
            if(dir != 4){
                int x = p.x + dx[dir];
                int y = p.y + dy[dir];
                if(!isValid(x,y,n,m) || mat[x][y]==1){
                    if(p.x==d[0] && p.y==d[1])  return dist[p.x][p.y][dir];			// so we reach destination
                    else {
                        for(int i=0;i<4;i++)
                        {
                            dist[p.x][p.y][i] = dist[p.x][p.y][dir];
                        }
                        dir=4;
                    }    
                } 

            }
            if(dir==4){					// go in all 4 dir
                for(int i=0;i<4;i++){
                    int x = p.x + dx[i];
                    int y = p.y + dy[i];
                    if(isValid(x,y,n,m) && mat[x][y]==0 && dist[x][y][i] > 1+dist[p.x][p.y][i]){
                        dist[x][y][i] = 1+dist[p.x][p.y][i];
                        q.add(new Pair(x,y,i));   
                    }
                }
            }
            else {
                int x = p.x + dx[dir];
                int y = p.y + dy[dir];
                if(dist[x][y][p.dir] > 1 + dist[p.x][p.y][p.dir]){
                    dist[x][y][p.dir] = 1 + dist[p.x][p.y][p.dir];
                    q.add(new Pair(x,y,dir));
                }
            }
        }
        return  -1;
    }
    private static boolean isValid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m)  return false;
        else return true;
    }

}
