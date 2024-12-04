package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.mh.dto.CharacterInfo;
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
		String ocid = service.ocidSearch(name);
		System.out.println("ocid 출력되나?=="+ocid);
		CharacterInfo c = service.getCharacterInfo(ocid);
		System.out.println("캐릭터인포 출력=="+c);
		return c;
	}
}
