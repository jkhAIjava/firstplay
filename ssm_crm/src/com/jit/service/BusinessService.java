package com.jit.service;

import java.util.List;

import com.jit.common.utils.Page;
import com.jit.model.BaseDict;
import com.jit.model.Customer;
import com.jit.model.QueryVo;

public interface BusinessService {

	List<BaseDict> getBaseDictBySource(String source);

	Page<Customer> getPage(QueryVo vo);

	Customer selectCustomerById(int id);

	void editCustomer(Customer customer);

	void deleteCustomerById(int id);
}