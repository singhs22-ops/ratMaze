package com.example.ratMazeproblem.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class FetchandPrintSolutionTest {

	@InjectMocks
	private FetchandPrintSolutionImpl fetchSolution;
	
	@Mock
	private SolvePathProblem solvePath;
	
	@Mock
	private JdbcTemplate jdbc;
	
	
	@Rule
	public final ExpectedException mockexception = ExpectedException.none();
	
	@Before
	public void setup() {
		
	}
	
	//@Test
//	public void getTrajectoryExceptionTest(){
//		mockexception.expect(Exception.class);
//		fetchSolution.getTrajectory("PENDING");
//	}
//	
	@Test
	public void getTrajectoryTest() {
		List<String> listofTypes = new ArrayList<>();
		listofTypes.add("type1");
		listofTypes.add("TYPE1");
		listofTypes.add("TYPE2");
		
		Mockito.when(fetchSolution.fetchTypeFromDB("PENDING")).thenReturn(listofTypes);
		
		int[][] TYPE1MAZE = { { 1, 1, 1, 1 ,0},
	            { 1, 1, 0, 0, 1 },
	            { 0, 1, 0, 1, 1},
	            { 1, 0, 1, 1, 1 },
	            { 1, 1, 1, 0, 1 } };
		
		Mockito.when(solvePath.findAllMazePath(TYPE1MAZE, TYPE1MAZE.length)).thenReturn(true);
		
		Mockito.when(jdbc.update(Mockito.anyString())).thenReturn(0);
		fetchSolution.getTrajectory("PENDING");
	}
}
