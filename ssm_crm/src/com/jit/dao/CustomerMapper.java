package com.jit.dao;

import java.util.List;

import com.jit.model.BaseDict;
import com.jit.model.Customer;
import com.jit.model.QueryVo;

public interface CustomerMapper {

	//查询分页后的List
	public List<Customer> pageResult(QueryVo vo);
	
	//查询符合条件的总页数
	public int getTotalPage(QueryVo vo);

	public Customer selectCustomerById(int id);

	public void editCustomer(Customer customer);

	public void deleteCustomerById(int id);

}
