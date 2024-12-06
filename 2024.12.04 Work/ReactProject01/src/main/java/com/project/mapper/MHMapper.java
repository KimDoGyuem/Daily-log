package com.project.mapper;

import java.util.ArrayList;

import com.project.mh.dto.CharacterInfo;
import com.project.mh.dto.SelectPartyDto;

public interface MHMapper {
	
	public void addCharacterList(CharacterInfo c);
	
	public ArrayList<CharacterInfo> characterList(String id);
	
	public void listReset(String id);
	
	public void idAddParty(SelectPartyDto s);
	
	public ArrayList<CharacterInfo> getMyParty(SelectPartyDto s);
	
	public void idRemoveParty(SelectPartyDto s);
}
