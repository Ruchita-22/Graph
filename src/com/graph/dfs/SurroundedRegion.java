package com.graph.dfs;

public class SurroundedRegion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void solve(char[][] mat) {
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[0].length;j++){
                if(i==0 || i==mat.length-1 || j==0 || j==mat[0].length-1){
                    if(mat[i][j]=='O')  
                        dfs(i,j,mat);
                }
            }
        }
        
        for(int i=0;i<mat.length;i++){
            for(int j=0; j<mat[0].length;j++){
                if(mat[i][j]=='O')  mat[i][j]='X';
                if(mat[i][j]=='#')  mat[i][j]='O'; 
            }
        }    
    }
    private static void dfs(int i, int j, char mat[][]){
        if(!isValid(i, j, mat))	return;
        if(mat[i][j]=='O'){
            mat[i][j] = '#';
            dfs(i-1,j,mat);
            dfs(i+1,j,mat);
            dfs(i,j-1,mat);
            dfs(i,j+1,mat);
        }
    }
    private static boolean isValid(int i, int j, char mat[][]) {
    	if(i<0 || i>=mat.length || j<0 || j>=mat[0].length ) return false;
    	else return true;
    }

}
