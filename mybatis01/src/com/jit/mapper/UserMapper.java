package com.jit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jit.model.QueryVo;
import com.jit.model.User;

public interface UserMapper {

	//动态代理开发
	/**
	 * 使用原生的做法,
	 * 1.生成UserDao
	 * 2.实现UserDao
	 * 暴露的问题是:有许多的垃圾代码,重复代码,
	 * 故有了 动态代理开发
	 * */
	
	//满足4个原则
	//1.使用的方法名	= user.xml中的方法名
	//2.接口的类路径	= user.xml中的命名空间名称
	//3.入参类型 = user.xml中的parameterType
	//4.返回值类型 = user.xml中的resultType

	User findById(Integer id);
	
	void insertUser(User user);
	
	List<User> findByName(QueryVo vo);
	
	List<User> findByUsername(String username);
	
	int totalCount();
	
	List<User> findByNamePass(User user);
	
//	List<User> findByIds(QueryVo vo);
	
//	List<User> findByIds(List list);
	
	List<User> findByIds(int[] arr);
	
	//@Param 传递多个参数,构成map,所以在ParamterType设为map,通过#{key}来获取value
//	User findByMap(@Param("username")String name,@Param("password")String mima);
	User findByMap(@Param("vo")QueryVo vo);
	
}
