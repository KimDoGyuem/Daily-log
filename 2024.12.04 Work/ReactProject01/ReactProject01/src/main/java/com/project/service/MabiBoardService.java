package com.project.service;

import java.util.ArrayList;

import com.project.listproc.ListProc;
import com.project.mh.board.dto.AccountDto;
import com.project.mh.board.dto.GuestDto;

public interface MabiBoardService {
	
	public ListProc getList(String category,String word,int currentPage);
	
	public GuestDto read(long m_no);
	public void del(long m_no);
	public void write(GuestDto g);
	public void modify(GuestDto g);
	public void reply(GuestDto g);
	public ArrayList<GuestDto> readReply(long ori);
	public void hits(long m_no);
	public ArrayList<GuestDto> hitsList();

	public void reg(AccountDto a);
	public boolean regCount(AccountDto a);
	public String log(AccountDto a);
	public boolean logCount(AccountDto a);
}
