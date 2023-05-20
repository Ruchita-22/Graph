package com.graph.dfs;

public class NumberOfIsland {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solve(int[][] mat) {
        int count = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    dfs(i,j,mat);
                    count++;
                } 
            }
        }
        return count;
    }
    private static void dfs(int i, int j, int mat[][]){
  
        if(!isValid(i, j, mat) || mat[i][j] == 0)	return;

        mat[i][j] = 0;      //visited

        dfs(i-1,j,mat);  
        dfs(i+1,j,mat); 
        dfs(i,j-1,mat);    
        dfs(i,j+1,mat); 
        dfs(i-1,j-1,mat); 
        dfs(i-1,j+1,mat); 
        dfs(i+1,j-1,mat); 
        dfs(i+1,j+1,mat); 
    }
    private static boolean isValid(int i, int j, int mat[][]) {
    	if(i<0 || i>=mat.length || j<0 || j>=mat[0].length ) return false;
    	else return true;
    }


}
