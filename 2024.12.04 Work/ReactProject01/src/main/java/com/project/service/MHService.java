package com.project.service;

import java.util.ArrayList;

import com.project.mh.dto.CharacterInfo;
import com.project.mh.dto.SelectPartyDto;

public interface MHService {
	public String ocidSearch(String name);
	public CharacterInfo getCharacterInfo(String ocid,String id);
	public ArrayList<CharacterInfo> characterList(String id);
	public void listReset(String id);
	public void idAddParty(SelectPartyDto s); 
	public ArrayList<CharacterInfo> getMyParty(String id,int no);
	public void idRemoveParty(SelectPartyDto s); 
}
