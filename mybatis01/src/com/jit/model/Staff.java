package com.jit.model;

import java.io.Serializable;

public class Staff implements Serializable{
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
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
	@Override
	public String toString() {
		return "Staff [id=" + id + ", name=" + name + "]";
	}
}
