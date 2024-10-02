package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.MemberDTO;
import com.example.demo.service.MemberService;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService service;
	
	// 목록 화면을 반환하는 메소드
	// /member/list
	// /member/list?page=1
	// /member/list?page=2
	@GetMapping("/list")
	public void list(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
		
		Page<MemberDTO> list = service.getList(page);
		
		model.addAttribute("list", list);
	}
	
	// 등록 화면을 반환하는 메소드
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 회원을 등록하는 메소드
	@PostMapping("/register")
	public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
		
		boolean result = service.register(dto);

		if(result) {
			
			// 회원가입에 성공했으면 목록화면으로 이동
			return "redirect:/member/list";
			
		} else {
			// 등록에 실패했으면 다시 회원가입 폼으로 이동하면서 에러메시지 표시
			redirectAttributes.addFlashAttribute("msg", "아이디가 중복되어 등록에 실패하였습니다");
			return "redirect:/member/register";
			
		}
	}
	
}
