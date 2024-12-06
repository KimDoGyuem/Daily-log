package com.project.controller;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.mh.board.dto.AccountDto;
import com.project.mh.board.dto.GuestDto;
import com.project.service.MabiBoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/mabi/*")
public class MabinogiHerosBoardController {

	private MabiBoardService service;
	
	@GetMapping("/getList")
	public void getList(@RequestParam("category")String category,@RequestParam(value="word",defaultValue = "")String word,@RequestParam(value = "currentPage",defaultValue = "1")int currentPage, Model model) {
		model.addAttribute("blp",service.getList(category,word,currentPage));
	}
	
	@GetMapping({"/read","/modify"})
	public void read(@RequestParam("m_no")Long m_no,Model model) {
		service.hits(m_no);
		model.addAttribute("read",service.read(m_no));
		model.addAttribute("reply",service.readReply(m_no));
	}
	
	@GetMapping("/del")
	public String del(@RequestParam("m_no")Long m_no , @RequestParam("category")String category) {
		service.del(m_no);
		String encodedCategory = URLEncoder.encode(category, StandardCharsets.UTF_8);
		return "redirect:/mabi/getList?category="+encodedCategory;
	}
	
	@GetMapping("/write")
	public void write(@RequestParam("category")String category,Model model) {
		model.addAttribute("category",category);
	}
	
	@PostMapping("/write")
	public String write(GuestDto g) {
		service.write(g);
		String encodedCategory = URLEncoder.encode(g.getM_category(), StandardCharsets.UTF_8);
		return "redirect:/mabi/getList?category="+encodedCategory;
	}
	
	@PostMapping("/modify")
	public String modify(GuestDto g) {
		service.modify(g);
		String encodedCategory = URLEncoder.encode(g.getM_category(), StandardCharsets.UTF_8);
		return "redirect:/mabi/getList?category="+encodedCategory;
	}
	
	@PostMapping("/reply")
	public String reply(GuestDto g){
		service.reply(g);
		String no = g.getM_reply_ori();
		return "redirect:/mabi/read?m_no="+no;
	}
	
	@RequestMapping("/board")
	public void board(Model model) {
		model.addAttribute("hitsList",service.hitsList());
	}

	@GetMapping("/reg")
	public void reg() {

	}

	@PostMapping("/reg")
	public String reg(AccountDto a, Model model) {
		if (service.regCount(a)) {
			model.addAttribute("error", "이미 존재하는 ID 입니다");
			return "/mabi/reg";
		}
		service.reg(a);
		return "redirect:/mabi/board";
	}

	@PostMapping("/log")
	public String log(HttpSession s, AccountDto a, Model model) {
		if (service.logCount(a)) {
			model.addAttribute("logError", "ID가 일치하지 않습니다");
			return "/mabi/board";
		} else {
			s.setAttribute("log", service.log(a));
			return "redirect:/mabi/board";
		}
	}

	@GetMapping("/logOut")
	public String logOut(HttpSession s) {
		s.invalidate();
		return "redirect:/mabi/board";
	}
	

}
