package com.project.mh.board.dto;

import lombok.Data;

@Data
public class GetListDto {
	
	private String category;
	private String word;
	private int offset = 0;
	private int rowCount = 0;
	
	public GetListDto(String category, int offset, int rowCOunt) {
		super();
		this.category = category;
		this.offset = offset;
		this.rowCount = rowCOunt;
	}
	public GetListDto(String category, String word, int offset, int rowCOunt) {
		super();
		this.category = category;
		this.word = word;
		this.offset = offset;
		this.rowCount = rowCOunt;
	}
	public GetListDto(String category, String word) {
		super();
		this.category = category;
		this.word = word;
	}
	
	
}
