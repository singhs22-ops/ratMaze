package com.example.ratMazeproblem.service;

@FunctionalInterface
public interface CheckPathSafety {

	public String isPathSafe( int[][] maze, int row, int column);
}
