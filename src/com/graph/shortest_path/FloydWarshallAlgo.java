package com.graph.shortest_path;

public class FloydWarshallAlgo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] solve(int[][] mat) {
        int n = mat.length;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j]==-1)    mat[i][j] = 100000000;
            }
        }
        for(int k=0; k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 100000000) mat[i][j] = -1;
            }
        }
        return mat;
    }

}
