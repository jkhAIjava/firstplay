package com.jit.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jit.common.utils.Page;
import com.jit.model.BaseDict;
import com.jit.model.Customer;
import com.jit.model.QueryVo;
import com.jit.service.BusinessService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource
	private BusinessService bs;
	
	@RequestMapping("/query.action")
	public String query(Model model,QueryVo vo){
		Page<Customer> page= bs.getPage(vo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		return "/list.action";
	}
	
	@RequestMapping("/toEdit.action")
	public @ResponseBody Customer toEdit(Model model,int id){
		
		Customer customer = bs.selectCustomerById(id);
		
		return customer;
	}
	
	@RequestMapping("/edit.action")
	public @ResponseBody void edit(Model model,Customer customer){
		Logger logger = Logger.getLogger(CustomerController.class);
		logger.info("ID为: "+customer.getCust_id()+" 的customer被修改");
		bs.editCustomer(customer);
	}
	
	@RequestMapping("/delete.action")
	public @ResponseBody void delete(Model model,int id){
		bs.deleteCustomerById(id);
	}
	
	
}
