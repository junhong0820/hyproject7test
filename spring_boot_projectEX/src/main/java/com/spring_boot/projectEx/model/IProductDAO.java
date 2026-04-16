package com.spring_boot.projectEx.model;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.ProductDTO;

public interface IProductDAO {
	public ArrayList<ProductDTO> listCtgProduct(String ctgId);
	public ProductDTO detailViewProduct(String prdNo);
}
