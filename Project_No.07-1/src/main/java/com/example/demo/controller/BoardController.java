package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;


@Controller
@RequestMapping("/board") // 중간경로 http://localhost:8080/dx3
public class BoardController {
	
	@Autowired
	BoardService service;
	
	// 메인 페이지 반환
	@GetMapping("/main")
	public void main() {
		
	}
	
	// 리스트 페이지 반환
	@GetMapping("/list")
	public void list(Model model) {
		
		List<BoardDTO> list = service.getList();
		
		model.addAttribute("list", list);
		// 서버에 입력된 데이터 화면 출력
		
	}
	
	// 등록 화면 반환
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 새로운 게시물 등록 (입력 후 서버 전달)
	@PostMapping("/register")
	public String registerPost(BoardDTO dto, RedirectAttributes attributes) {
		
		int no = service.register(dto);
		
		attributes.addFlashAttribute("no", no);
		
		return "redirect:/board/list";
		
	}
	
	// 상세 화면 반환
	@GetMapping("/read")
	public void read(@RequestParam(name = "no") int no, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}
	
	// 수정 화면 반환
	@GetMapping("/modify")
	public void modify(@RequestParam(name = "no") int no, Model model) {
		BoardDTO dto = service.read(no);
		model.addAttribute("dto", dto);
	}
	
	// 수정 처리
	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto, RedirectAttributes attributes) {
		service.modify(dto);
		attributes.addAttribute("no", dto.getNo());
		return "redirect:/board/read";
	}
	
	// 삭제 처리
	@PostMapping ("/remove")
	public String removePost(@RequestParam("no") int no) {
		service.remove(no);
		return "redirect:/board/list";
	}
	
}
