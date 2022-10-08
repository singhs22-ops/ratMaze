package com.example.ratMazeproblem.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CheckPathSafetyImplTest {

	@InjectMocks
	private CheckPathSafetyImpl checkpathSafetytest;
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void isPathSafeTest() {
		int [][] maze = { { 1, 0, 0, 0 },
            { 1, 1, 0, 1 },
            { 0, 1, 0, 0 },
            { 1, 1, 1, 1 } };
		checkpathSafetytest.isPathSafe(maze, 0, 0);
	}
}
