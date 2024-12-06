package com.project.mapper;

import java.util.ArrayList;

import com.project.mh.board.dto.AccountDto;
import com.project.mh.board.dto.GetListDto;
import com.project.mh.board.dto.GuestDto;

public interface MabiMapper {

	public ArrayList<GuestDto> getList(GetListDto gl);
	public int getPostCount(String category);
	
	public ArrayList<GuestDto> getSearchList(GetListDto gl);
	public int getSearchPostCount(GetListDto gl);
	
	public GuestDto read(long m_no);
	public void del(long m_no);
	public void write(GuestDto g);
	public void modify(GuestDto g);
	public void reply(GuestDto g);
	public ArrayList<GuestDto> readReply(long ori);
	public void hits(long m_no);
	public ArrayList<GuestDto> hitsList();
	
	public void reg(AccountDto a);
	public int regCount(AccountDto a);
	public AccountDto log(AccountDto a);
	public int logCount(AccountDto a);
}
