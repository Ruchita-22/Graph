package com.graph.dfs;

///https://www.youtube.com/watch?v=g6HzWspalpU&list=PLpO3gASfJEIJ6cYs4kAY3SnH2kpohSTZI&index=13
//https://leetcode.com/problems/flood-fill/description/
public class FloodFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] floodFill(int[][] mat, int i, int j, int color) {
        if(mat[i][j]==color)    return mat;
        dfs(i,j,mat[i][j],color,mat);
        return mat;
    }
    private static void dfs(int i, int j, int oc , int nc,int[][] mat){
    	if(!isValid(i, j, mat))	return;
        
    	if(mat[i][j]==oc){
            mat[i][j] = nc;
            dfs(i-1,j,oc,nc,mat);
            dfs(i+1,j,oc,nc,mat);
            dfs(i,j-1,oc,nc,mat);
            dfs(i,j+1,oc,nc,mat);
        }
        
    }
    private static boolean isValid(int i, int j, int mat[][]) {
    	if(i<0 || i>=mat.length || j<0 || j>=mat[0].length ) return false;
    	else return true;
    }

}
