package com.project.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.project.listproc.ListProc;
import com.project.mapper.MabiMapper;
import com.project.mh.board.dto.AccountDto;
import com.project.mh.board.dto.GuestDto;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MabiBoardServiceImpl implements MabiBoardService{
	
	private MabiMapper mapper;
	
	public ListProc getList(String category, String word, int currentPage) {
		return new ListProc(mapper,category,word,currentPage);
	}
	
	public GuestDto read(long m_no) {
		return mapper.read(m_no);
	}
	public void del(long m_no) {
		mapper.del(m_no);
	}
	public void write(GuestDto g) {
		mapper.write(g);
	}
	public void modify(GuestDto g) {
		mapper.modify(g);
	}
	public void reply(GuestDto g) {
		mapper.reply(g);
	}
	public ArrayList<GuestDto> readReply(long ori) {
		return mapper.readReply(ori);
	}
	public void hits(long m_no) {
		mapper.hits(m_no);
	}
	public ArrayList<GuestDto> hitsList(){
		return mapper.hitsList();
	}
	
	public void reg(AccountDto a) {
		mapper.reg(a);
	}
	public boolean regCount(AccountDto a) {
		return mapper.regCount(a)>0;
	}
	public String log(AccountDto a) {
		String id = mapper.log(a).getId();
		return id;
	}
	public boolean logCount(AccountDto a) {
		return mapper.logCount(a)<=0;
	}
}
