package com.project.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.mh.dto.CharacterInfo;
import com.project.mh.dto.MHCharacterBasicDto;
import com.project.mh.dto.MHCharacterStatDto;
import com.project.mh.dto.MHOcidDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MHServiceImpl implements MHService {

	private final String API_KEY = "test_6cef866ab2c35ada7007397305e74d6f035f8cd449a2e8b3b9cdb6909e5d9febefe8d04e6d233bd35cf2fabdeb93fb0d";

	public String ocidSearch(String name) {

		String encodedName = "";
		try {
			encodedName = URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error("Encoding error: " + e.getMessage());
		}

		String API_URL = "https://open.api.nexon.com/heroes/v2/id?character_name=" + encodedName;
		RestTemplate restTemplate = new RestTemplate();
		URI uri = null;

		try {
			uri = new URI(API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		String ocid = "";
		try {
			ResponseEntity<MHOcidDto> response = restTemplate.exchange(uri, HttpMethod.GET, entity, MHOcidDto.class);
			MHOcidDto o = response.getBody();
			if (o != null && o.ocid != null) {
				ocid = o.ocid;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ocid;
	}

	public CharacterInfo getCharacterInfo(String ocid) {

		String BASIC_API_URL = "https://open.api.nexon.com/heroes/v2/character/basic?ocid=" + ocid;
		String STAT_API_URL = "https://open.api.nexon.com/heroes/v2/character/stat?ocid="+ocid;
		
		RestTemplate restTemplate = new RestTemplate();
		URI basicUri = null;
		URI statUri = null;
		CharacterInfo cInfo = new CharacterInfo();

		try {
			basicUri = new URI(BASIC_API_URL);
			statUri = new URI(STAT_API_URL);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		HttpHeaders headers = new HttpHeaders();
		headers.set("accept", "application/json");
		headers.set("x-nxopen-api-key", API_KEY);
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		try {
			MHCharacterBasicDto cb = restTemplate.exchange(basicUri, HttpMethod.GET, entity, MHCharacterBasicDto.class).getBody();
			if (cb == null) {
				System.out.println("==cb가null임==");
			} else {
				cInfo.setCharacter_name(cb.character_name);
				cInfo.setClass_name(cb.character_class_name);
				cInfo.setLevel(cb.character_level);
			}
			
			MHCharacterStatDto cs = restTemplate.exchange(statUri, HttpMethod.GET, entity, MHCharacterStatDto.class).getBody();
			if(cs == null) {
				System.out.println("==cs가null임==");
			}else {
				cInfo.setOffensive_power(cs.stat.get(0).stat_value);
				cInfo.setMagic_power(cs.stat.get(1).stat_value);
				cInfo.setAdditional_damage(cs.stat.get(11).stat_value);
				cInfo.setCritical(cs.stat.get(12).stat_value);
				cInfo.setBalance(cs.stat.get(15).stat_value);
				cInfo.setUnrestricting_Attacks(cs.stat.get(16).stat_value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cInfo;
	}
	
}
