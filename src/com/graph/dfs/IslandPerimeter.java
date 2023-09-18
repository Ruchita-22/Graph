package com.graph.dfs;

//https://leetcode.com/problems/island-perimeter/description/
//https://www.youtube.com/watch?v=KEyd_d9EA0c&list=PLpO3gASfJEIJ6cYs4kAY3SnH2kpohSTZI&index=12
public class IslandPerimeter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int count;
    public int islandPerimeter(int[][] mat) {
        count = 0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 1){
                    dfs(i,j,mat);
                }    
            }
        }
        return count;
        
    }
    private static void dfs(int i, int j, int mat[][]){
    	int n = mat.length;
    	int m = mat[0].length;
    	
        if(!isValid(i, j, n, m) || mat[i][j]==0){   
            count++;
            return;
        }    
        if(mat[i][j]==-1)   return;	//already visited

        mat[i][j] = -1;
        dfs(i-1,j,mat);
        dfs(i+1,j,mat);
        dfs(i,j-1,mat);
        dfs(i,j+1,mat);
    }
    private static boolean isValid(int i, int j, int n, int m) {
    	if(i < 0 || i >= n || j < 0 || j >= m ) return false;
    	else return true;
    }
    

}
