package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring_boot.projectEx.dto.ProductDTO;
import com.spring_boot.projectEx.service.IProductService;

@Controller
public class ProductController {

		@Autowired
		IProductService prdService;
	
		@GetMapping("/product/productListCtg/{ctgId}")
		public String productCtgList(@PathVariable String ctgId, Model model) {
			ArrayList<ProductDTO> prdList=prdService.listCtgProduct(ctgId);
			model.addAttribute("prdList",prdList);
			
			return "product/productCtgListView";
		}
		
		@GetMapping("/product/detailViewProduct/{prdNo}")
		public String detailViewProduct(@PathVariable String prdNo, Model model) {
			ProductDTO prd = prdService.detailViewProduct(prdNo);
			model.addAttribute("prd",prd);
			
			return "product/productDetailView";
		}
}

















