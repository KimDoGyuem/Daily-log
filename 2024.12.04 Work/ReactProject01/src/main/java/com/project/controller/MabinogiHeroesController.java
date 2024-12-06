package com.project.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mh.dto.CharacterInfo;
import com.project.mh.dto.SelectPartyDto;
import com.project.service.MHService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
@RequestMapping("/mh/*")
public class MabinogiHeroesController {
	
	private MHService service;
	
	@RequestMapping("/characterSearch")
	public CharacterInfo characterSearch(@RequestParam("name")String name) {
		String id = null;
		String ocid = service.ocidSearch(name);
		System.out.println("ocid 출력되나?=="+ocid);
		CharacterInfo c = service.getCharacterInfo(ocid,id);
		System.out.println("캐릭터인포 출력=="+c);
		return c;
	}
	
	@RequestMapping("/loginCharacterSearch")
	public CharacterInfo loginCharacterSearch(@RequestParam("name")String name, @RequestParam("id")String id) {
		String ocid = service.ocidSearch(name);
		System.out.println("ocid 출력되나?=="+ocid);
		CharacterInfo c = service.getCharacterInfo(ocid,id);
		System.out.println("캐릭터인포 출력=="+c);
		return c;
	}
	
	@RequestMapping("/characterList")
	public ArrayList<CharacterInfo> characterList(@RequestParam("id")String id){
		ArrayList<CharacterInfo> c = service.characterList(id);
		return c;
	}
	
	@RequestMapping("/listReset")
	public void listReset(@RequestParam("id")String id) {
		service.listReset(id);
	}

	@RequestMapping("/idAddParty")
	public void idAddParty(@RequestBody SelectPartyDto s) {
		service.idAddParty(s);
	}
	
	@RequestMapping("/getMyParty")
	public ArrayList<CharacterInfo> getMyParty(@RequestParam("id")String id, @RequestParam("no")int no){
		ArrayList<CharacterInfo> c = service.getMyParty(id,no);
		return c;
	}
	
	@RequestMapping("/idRemoveParty")
	public void idRemoveParty(@RequestBody SelectPartyDto s) {
		service.idRemoveParty(s);
	}
}
