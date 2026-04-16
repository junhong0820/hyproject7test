package com.spring_boot.projectEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.model.ICartDAO;

@Service
@Primary
public class CartService implements ICartService {
	@Autowired
	ICartDAO dao;
	
	@Override
	public void insertCart(CartDTO dto) {
		dao.insertCart(dto);		
	}

	@Override
	public int checkPrdInCart(String prdNo, String memId) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("prdNo", prdNo);
		map.put("memId", memId);
		return dao.checkPrdInCart(map);
	}

	@Override
	public void updateQtyInCart(CartDTO dto) {
		dao.updateQtyInCart(dto);		
	}

	@Override
	public ArrayList<CartDTO> cartList(String memId) {
		return dao.cartList(memId);
	}

	@Override
	public void deleteCart(String cartNo) {
		dao.deleteCart(cartNo);
		}

	@Override
	public void updateCart(int[] cartNo, int[] cartQty) {
		for(int i=0; i<cartNo.length;i++) {
			System.out.println(cartNo[i]);
			System.out.println(cartQty[i]);
			HashMap<String,Integer> map = new HashMap<String,Integer>();
			map.put("cartNo",cartNo[i]);
			map.put("cartQty", cartQty[i]);
			dao.updateCart(map);
		}
	}
	
	

}
