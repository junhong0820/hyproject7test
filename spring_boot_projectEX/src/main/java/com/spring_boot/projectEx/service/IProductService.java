package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.ProductDTO;

public interface IProductService {
	public ArrayList<ProductDTO> listCtgProduct(String ctdId);
	public ProductDTO detailViewProduct(String prdNo);
}
