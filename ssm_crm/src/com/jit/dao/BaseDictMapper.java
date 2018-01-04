package com.jit.dao;


import java.util.List;

import com.jit.model.BaseDict;
import com.jit.model.QueryVo;


public interface BaseDictMapper {

	public List<BaseDict> getBaseDictBySource(String source);
	
	
}
