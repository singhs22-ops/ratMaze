package com.example.ratMazeproblem.service;

import java.util.List;

public interface FetchandPrintSolution {

	public void getTrajectory(String status);
	public List<String> fetchTypeFromDB(String status);
}
