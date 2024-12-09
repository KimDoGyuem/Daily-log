package com.project.mh.board.dto;

import lombok.Data;

@Data
public class CheckLogDto {
	private String date;
	private String id;
	
	public CheckLogDto(String date, String id) {
		super();
		this.date = date;
		this.id = id;
	}
	
}
