package com.jit.model;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private List idsList;
	private int[] ids;
	
	public List getIdsList() {
		return idsList;
	}
	public void setIdsList(List idsList) {
		this.idsList = idsList;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
