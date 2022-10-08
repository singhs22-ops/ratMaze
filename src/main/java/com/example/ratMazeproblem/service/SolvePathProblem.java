package com.example.ratMazeproblem.service;

public interface SolvePathProblem {

	public boolean findAllMazePath(int [][] maze, int N);
	public boolean solveUntilSolution(int [][] maze, int row, int column, int [][] solutionMatrix);
	public void printTrajectoryofTraversalinMat(int [][]solutionMatrix);
	
}
