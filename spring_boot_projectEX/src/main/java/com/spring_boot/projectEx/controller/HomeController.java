package com.spring_boot.projectEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//main 페이지 요청 처리
	//@RequestMapping
	@GetMapping("/")
	public String index() {
		return "index";
	}
}
