package com.project.mh.dto;

public class SelectPartyDto {

	String  id;
	String character_name;
	int no;
	
	public SelectPartyDto() {
		super();
	}

	public SelectPartyDto(String id, String character_name) {
		super();
		this.id = id;
		this.character_name = character_name;
	}

	public SelectPartyDto(String id, int no) {
		super();
		this.id = id;
		this.no = no;
	}
	
}
