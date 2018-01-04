package com.jit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jit.common.utils.Page;
import com.jit.model.BaseDict;
import com.jit.model.Customer;
import com.jit.model.QueryVo;
import com.jit.service.BusinessService;

@Controller
public class BaseDictController {
	
	@Resource
	private BusinessService bs;
	
	@RequestMapping("/list.action")
	public String test1(Model model){
		List<BaseDict> industryType = bs.getBaseDictBySource("001");
		List<BaseDict> fromType = bs.getBaseDictBySource("002");
		List<BaseDict> levelType = bs.getBaseDictBySource("006");
		model.addAttribute("industryType", industryType);
		model.addAttribute("fromType", fromType);
		model.addAttribute("levelType", levelType);
		
//		if(page!=null){
//			model.addAttribute("pag", arg1)
//		}
		
		return "/WEB-INF/jsp/customer.jsp";
	}
}
