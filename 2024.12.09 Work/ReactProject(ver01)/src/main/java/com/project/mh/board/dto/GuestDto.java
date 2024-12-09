package com.project.mh.board.dto;

import lombok.Data;

@Data
public class GuestDto {
	private Long m_no;
	private String m_title;
	private String m_id;
	private String m_text;
	private String m_category;
	private Long m_hits;
	private String m_reply_ori;
	private String m_reply_id;
	private String m_reply_text;
}
