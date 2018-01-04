package com.jit.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jit.dao.CustomerMapper;
import com.jit.model.BaseDict;
import com.jit.model.Customer;
import com.jit.service.BusinessService;

public class Demo {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:spring/applicationContext_*.xml");
		CustomerMapper cm=(CustomerMapper) app.getBean("CustomerMapper");
		Customer c=cm.selectCustomerById(24);
		System.out.println(c);
	}
}
