package com.project.service;

import com.project.mh.dto.CharacterInfo;

public interface MHService {
	public String ocidSearch(String name);
	public CharacterInfo getCharacterInfo(String ocid);
}
