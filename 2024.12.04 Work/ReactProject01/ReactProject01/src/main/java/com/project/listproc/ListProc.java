package com.project.listproc;

import java.util.ArrayList;

import com.project.mapper.MabiMapper;
import com.project.mh.board.dto.GetListDto;
import com.project.mh.board.dto.GuestDto;

import lombok.Data;

@Data
public class ListProc {
	private MabiMapper mapper;
	String category;
	String word;
	public ArrayList<GuestDto> posts;
	
	final int LISTCOUNTPERPAGE = 3;
	final int PAGESPERBLOCK = 3;
	int totalPage = 0;
	int currentPage = 0;
	int totalBlock = 0;
	int currentBlockNo = 0;
	int blockStartNo = 0;
	int blockEndNo = 0;
	int prevPage = 0;
	int nextPage = 0;
	boolean hasPrev = true;
	boolean hasNext = true;
	
	public void getList() {
		int startIndex = (currentPage-1)*LISTCOUNTPERPAGE;
		GetListDto gl = new GetListDto(category,startIndex,LISTCOUNTPERPAGE);
		posts = mapper.getList(gl);
	}
	public int getPageCount() {
		int totalPageCount = 0;
		int count = mapper.getPostCount(category);
		if(count%LISTCOUNTPERPAGE==0) {
			totalPageCount = count/LISTCOUNTPERPAGE;
		}else {
			totalPageCount = count/LISTCOUNTPERPAGE+1;
		}
		return totalPageCount;
	}
	
	public void getSearchList() {
		int startIndex = (currentPage-1)*LISTCOUNTPERPAGE;
		GetListDto gl = new GetListDto(category,word,startIndex,LISTCOUNTPERPAGE);
		posts = mapper.getSearchList(gl);
	}
	
	public int getSearchPageCount() {
		int totalPageCount = 0;
		GetListDto gl = new GetListDto(category,word);
		int count = mapper.getSearchPostCount(gl);
		if(count%LISTCOUNTPERPAGE==0) {
			totalPageCount = count/LISTCOUNTPERPAGE;
		}else {
			totalPageCount = count/LISTCOUNTPERPAGE+1;
		}
		return totalPageCount;
	}
	
	public ListProc(MabiMapper mapper,String category,String word,int currentPage) {
		super();
		this.mapper = mapper;
		this.category = category;
		this.word = word;
		this.currentPage = currentPage;
		if(word.equals("")) {
			totalPage = getPageCount();
			getList();
		}else {
			totalPage = getSearchPageCount();
			getSearchList();
		}
		totalBlock = (int)Math.ceil((double)totalPage/PAGESPERBLOCK);
		currentBlockNo = (int)Math.ceil((double)this.currentPage/PAGESPERBLOCK);
		blockStartNo = (currentBlockNo-1)*PAGESPERBLOCK+1;
		blockEndNo = currentBlockNo*PAGESPERBLOCK;
		if(blockEndNo>totalPage) {
			blockEndNo = totalPage;
		}
		if(currentBlockNo==1) {
			hasPrev = false;
		}else {
			hasPrev = true;
			prevPage = (currentBlockNo-1)*PAGESPERBLOCK;
		}
		if(currentBlockNo<totalBlock) {
			hasNext = true;
			nextPage = currentBlockNo*PAGESPERBLOCK+1;
		}else {
			hasNext = false;
		}
	}
}
