package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.service.ICartService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	ICartService cartService;
	
	//장바구니 추가 요청
	@PostMapping("/product/insertCart")
	public String insertCart(CartDTO dto, HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		dto.setMemId(memId);
		
		//동일 상품이 존재하는지 확인
		int count = cartService.checkPrdInCart(dto.getPrdNo(),memId);
		
		if(count==0) {//동일상품이 존재하지 않으면
			cartService.insertCart(dto);
		}else {
			cartService.updateQtyInCart(dto);
		}
		return "redirect:/product/cartList";
	}
	
	//장바구니 목록보기 요청 처리
	@GetMapping("/product/cartList")
	public String cartList(HttpSession session,Model model) {
		String memId = (String)session.getAttribute("sid");
		ArrayList<CartDTO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		return "product/cartListView";
	}
	
	//장바구니 삭제
	@ResponseBody
	@PostMapping("/product/deleteCart")
	public int deleteCart(@RequestParam("delPrd") ArrayList<String> chkArr) {
		int result=0;
		if(chkArr != null) {
			for(String cartNo:chkArr) {
				cartService.deleteCart(cartNo);
			}
			result=1;
		}
		
		return result;
	}
}





























