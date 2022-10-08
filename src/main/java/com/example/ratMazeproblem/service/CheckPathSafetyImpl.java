package com.example.ratMazeproblem.service;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.stereotype.Service;

@Service
public class CheckPathSafetyImpl implements CheckPathSafety {

	@Override
	public String isPathSafe(int [][] maze, int row, int column) {
		
		int sizeofMatrix = maze.length;
		boolean returnBoolean = (row >= 0 && row < sizeofMatrix && column >= 0
                && column < sizeofMatrix && maze[row][column] == 1);
		
		if(BooleanUtils.isFalse(returnBoolean)) {
			return "false";
		}
		return "true";
	}

}
