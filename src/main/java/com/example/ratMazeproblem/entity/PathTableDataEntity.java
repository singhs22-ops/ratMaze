package com.example.ratMazeproblem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(schema = "onemat", name = "maze_table")
public class PathTableDataEntity {

	@Id
	@Column(name = "mid")
	private int mid;
	
	@Column(name= "status")
	private String status;
	
	@Column(name = "type")
	private String type;
}
