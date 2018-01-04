package com.jit.mapper;

import java.util.List;

import com.jit.model.Department;
import com.jit.model.PersonCard;
import com.jit.model.Staff;

public interface DepartmentMapper {

	//通过id招personcard并且里有user
	Department findById(int id);
	
}
