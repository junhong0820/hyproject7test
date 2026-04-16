package com.spring_boot.projectEx.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dto.MemberDTO;


public interface IMemberService {
	public String loginCheck(HashMap<String, Object> map);
	public String idCheck(String id);
	public void insertMember(MemberDTO dto);
	
}
