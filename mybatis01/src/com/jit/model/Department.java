package com.jit.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id ;
	private String name;
	
	private Set<Staff> set=new HashSet<Staff>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Staff> getSet() {
		return set;
	}

	public void setSet(Set<Staff> set) {
		this.set = set;
	}
	
}
