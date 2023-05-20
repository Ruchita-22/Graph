package com.graph.bfs;

import java.util.*;

public class KnightOnChessBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Pair{
	    int x, y;
	    public Pair(int x, int y){
	        this.x = x;
	        this.y = y;
	    }
	}
	public int knight(int n, int m, int si, int sj, int di, int dj) {
        //convert i base to 0 base indexing
        si = si-1;
        sj = sj-1;
        di = di-1;
        dj = dj-1;
        //edge case
        if(!isValid(si,sj,n,m)) return -1;
        if(!isValid(di,dj,n,m)) return -1;
        if(si==di && sj==dj)    return 0;

        int dist[][] = new int[n][m];
        for(int t[] : dist) Arrays.fill(t,100000000);

        int dx[] = new int[]{-2, -2,1,1,-1,-1,2,2};
        int dy[] = new int[]{1,-1,2,-2,2,-2,-1,1};

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(si,sj));
        dist[si][sj] = 0;

        while(q.size()>0){
            Pair p = q.poll();
            for(int i=0;i<8;i++){
                int x = p.x + dx[i];
                int y = p.y + dy[i]; 
                if(isValid(x,y,n,m) && dist[x][y] > 1+dist[p.x][p.y]){
                    dist[x][y] = 1+dist[p.x][p.y];
                    q.add(new Pair(x,y));
                }
            }
        }
        return dist[di][dj] != 100000000  ? dist[di][dj] : -1;
    }
    private static boolean isValid(int i, int j, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m)  return false;
        else return true;
    }

}
