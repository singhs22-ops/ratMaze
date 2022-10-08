package com.example.ratMazeproblem.service;

import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.ratMazeproblem.Constants.MazeConstants;
import com.example.ratMazeproblem.repository.MazeRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class FetchandPrintSolutionImpl implements FetchandPrintSolution {

	@Autowired
	private MazeRepository mazeRepo;
	
	@Autowired
	private SolvePathProblem solvePath;
	
	
	@Autowired
	private JdbcTemplate jdbc;
	
	
	@Override
	public void getTrajectory(String status) {
		//fetch status based status which can be pending if not solved
		//status = Pending
		try {
			int [][] inputMaze ;
			
			List<String> typeList = fetchTypeFromDB(status);
			for(String typeItem: typeList) {
				if(StringUtils.equals("TYPE2",typeItem)) {
					inputMaze = MazeConstants.TYPE1MAZE;
				}
				else {
					inputMaze = MazeConstants.TYPE2MAZE;
				}
				if(BooleanUtils.isTrue(solvePath.findAllMazePath(inputMaze,inputMaze.length))){
					String query = "update onemat.maze_table set status =\'UPDATED\' where type = \'%s\'";
				 jdbc.update(String.format(query, typeItem));
				}
				
			}
		}
		catch(Exception e) {
			throw e;
		}
		System.exit(0);
	}
	

	@Override
	public List<String> fetchTypeFromDB(String status) {
		String query = "select type from onemat.maze_table where status =\'%s\'";
		
		List<String> queryForList = jdbc.queryForList(String.format(query, status), String.class);
		System.out.println("List of Data Types received from DataBase"+queryForList);
		return queryForList;
	}
	
	
}
