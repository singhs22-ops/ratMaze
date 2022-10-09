package com.example.ratMazeproblem.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SolvePathProblemImpltest {

	@InjectMocks
	private SolvePathProblemImpl solvePath;
	
	int solutionReachedFlag = 0;
	
	int[][] TYPE1MAZE = { { 1, 1, 1, 1 ,0},
            { 1, 1, 0, 0, 1 },
            { 1, 1, 0, 1, 1 },
            { 1, 0, 1, 1, 1 },
            { 1, 1, 1, 0, 1 } };
	
    @Mock
    private CheckPathSafety checkPath;
            
	@Before
	public void setup() {
		//Whitebox.setInternalState(checkPath, solutionReachedFlag, 0);
	}
	
	@Test
	public void findAllMazePathTest() {
		
		solvePath.findAllMazePath(TYPE1MAZE, 5);
	}
	
	@Test
	public void solveUntilSolutionTest() {
		int sol[][] = { { 1, 1, 0, 0 ,0},
				{ 0, 1, 0, 0, 0 },
	            { 1, 1, 0, 0, 0 },
	            { 1, 0, 1, 1, 1 },
	            { 1, 1, 1, 0, 0 } };
		
		int solutionMatrix[][] = new int[5][5];
		Mockito.when(checkPath.isPathSafe(TYPE1MAZE, solutionReachedFlag, solutionReachedFlag)).thenReturn("true");
		solvePath.solveUntilSolution(TYPE1MAZE, solutionReachedFlag, solutionReachedFlag, solutionMatrix);
	}
	
	@Test
	public void printTrajectoryofTraversalinMatTest() {
		solvePath.printTrajectoryofTraversalinMat(TYPE1MAZE);
	}
}
