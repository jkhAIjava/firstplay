package com.jit.mapper;

import java.util.List;

import com.jit.model.PersonCard;

public interface PersonCardMapper {

	//通过id招personcard并且里有user
	List<PersonCard> findById();
	
}
