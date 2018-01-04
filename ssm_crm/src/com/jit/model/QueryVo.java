package com.jit.model;

import java.util.List;

public class QueryVo {

	//基础属性
	private int page = 1; //默认是当前页第一页
	private int rows = 5;		//默认一页5条记录
	private int startindex;
	//条件查询的属性
	private String custName;
	private String custSource;
	private String custIndustry;
	private String custLevel;
	
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	public void setList(List<Customer> list) {
		this.list = list;
	}
	public int getStartindex() {
		this.startindex = (this.page-1)*this.rows;
		return startindex;
	}
	public void setStartindex(int startindex) {
		this.startindex = startindex;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	
	public String getCustIndustry() {
		return custIndustry;
	}
	public void setCustIndustry(String custIndustry) {
		this.custIndustry = custIndustry;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "QueryVo [page=" + page + ", rows=" + rows + ", startindex=" + startindex + ", custName=" + custName
				+ ", custSource=" + custSource + ", custIndustry=" + custIndustry + ", custLevel=" + custLevel + "]";
	}
}
