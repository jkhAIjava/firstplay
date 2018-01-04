package com.jit.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jit.common.utils.Page;
import com.jit.dao.BaseDictMapper;
import com.jit.dao.CustomerMapper;
import com.jit.model.BaseDict;
import com.jit.model.Customer;
import com.jit.model.QueryVo;
import com.jit.service.BusinessService;

@Service("businessService")
public class BusinessServiceImpl implements BusinessService {

	@Resource(name="baseDictMapper")
	private BaseDictMapper bm;
	@Resource(name="customerMapper")
	private CustomerMapper cm;
	
	//提供数据字典
	public List<BaseDict> getBaseDictBySource(String source){
		return bm.getBaseDictBySource(source);
	} 
	
	//条件分页查询
	public Page<Customer> getPage(QueryVo vo){
		Page<Customer> page = new Page<Customer>();
		//debug过,传过来的vo各个数据都不为null 不输入条件只为""
		if(vo.getCustName()!=null && !"".equals(vo.getCustName().trim())){
			vo.setCustName(vo.getCustName());
		}else{
			vo.setCustName(null);
		}
		if(vo.getCustIndustry()!=null && !"".equals(vo.getCustIndustry().trim())){
			vo.setCustIndustry(vo.getCustIndustry());
		}else{
			vo.setCustIndustry(null);
		}
		if(vo.getCustLevel()!=null && !"".equals(vo.getCustLevel().trim())){
			vo.setCustLevel(vo.getCustLevel());
		}else{
			vo.setCustLevel(null);
		}
		if(vo.getCustSource()!=null && !"".equals(vo.getCustSource().trim())){
			vo.setCustSource(vo.getCustSource());
		}else{
			vo.setCustSource(null);
		}
//		System.out.println("??"+vo);
		int totalPage = cm.getTotalPage(vo);
		page.setTotal(totalPage);
		List<Customer> list = cm.pageResult(vo);
		page.setRows(list);

		//private int page;	//当前页
		//private int size;	//一夜多少条记录
		page.setPage(vo.getPage());
		page.setSize(vo.getRows());
		return page;
	}
	
	public Customer selectCustomerById(int id){
		
		return cm.selectCustomerById(id);
	}
	
	public void editCustomer(Customer customer){
	
		cm.editCustomer(customer);
	}
	
	public void deleteCustomerById(int id){
		cm.deleteCustomerById(id);
	}
	
}
