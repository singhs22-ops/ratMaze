package com.example.ratMazeproblem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolvePathProblemImpl implements SolvePathProblem {

	@Autowired
	private CheckPathSafety checkPath;
	int solutionReachedFlag = 0;

	@Override
	public boolean findAllMazePath(int[][] maze, int N) {

		int sol[][] = new int[N][N];

		if (solveUntilSolution(maze, 0, 0, sol) == false && (solutionReachedFlag == 0)) {
			System.out.println("Solution doesn't exist");
			return false;
		}
		printTrajectoryofTraversalinMat(sol);
		return true;
	}

	@Override
	public void printTrajectoryofTraversalinMat(int[][] solutionMatrix) {

		System.out.println("SolutionPath/Trajectory of Matrix");
		for (int i = 0; i < solutionMatrix.length; i++) {
			for (int j = 0; j < solutionMatrix.length; j++)
				System.out.print(" " + solutionMatrix[i][j] + " ");
			System.out.println();
		}
		System.gc();
	}

	@Override
	public boolean solveUntilSolution(int[][] maze, int row, int column, int[][] solutionMatrix) {

		int N = maze.length;

		if (row == N - 1 && column == N - 1 && maze[row][column] == 1) {
			solutionMatrix[row][column] = 1;
			return true;
		}

		if (checkPath.isPathSafe(maze, row, column) == "true") {
			if (solutionMatrix[row][column] == 1)
				return false;

			solutionMatrix[row][column] = 1;

			if (row == 3 && column == 4) {
				solutionReachedFlag = 1;
				return true;
			}

			if (solveUntilSolution(maze, row, column + 1, solutionMatrix))
				return true;

			if (solveUntilSolution(maze, row + 1, column, solutionMatrix))
				return true;

			
			if (solveUntilSolution(maze, row - 1, column, solutionMatrix))
				return true;

			if (solveUntilSolution(maze, row, column - 1, solutionMatrix))
				return true;

			solutionMatrix[row][column] = 0;
			return false;
		}

		return false;

	}

}
