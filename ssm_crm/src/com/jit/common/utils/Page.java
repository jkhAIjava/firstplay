package com.jit.common.utils;

import java.util.List;

public class Page<T> {
    
	private int total;	//总页数
	private int page;	//当前页
	private int size;	//一夜多少条记录
    private List<T> rows;	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
	
    
}
