package com.example.ratMazeproblem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ratMazeproblem.entity.PathTableDataEntity;

@Repository
public interface MazeRepository extends JpaRepository<PathTableDataEntity, Integer> {

//	@Query(value = "select type from ONEMAT.maze_table where status = :status")
//	public String getTypeConstant(@Param("status") String status);
	
}
