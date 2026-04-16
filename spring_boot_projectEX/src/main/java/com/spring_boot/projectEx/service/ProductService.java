package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dto.ProductDTO;
import com.spring_boot.projectEx.model.IProductDAO;

@Service
@Primary
public class ProductService implements IProductService {
	@Autowired
	IProductDAO dao;
	
	@Override
	public ArrayList<ProductDTO> listCtgProduct(String ctdId) {		
		return dao.listCtgProduct(ctdId);
	}

	@Override
	public ProductDTO detailViewProduct(String prdNo) {		
		return dao.detailViewProduct(prdNo);
	}
	
}











