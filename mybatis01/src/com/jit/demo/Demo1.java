package com.jit.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jit.mapper.UserMapper;
import com.jit.model.User;

public class Demo1 {

	@Test
	//where 条件查询
	public void firstDemo1() throws Exception{
		
		//1.通过SqlSessionFactoryBuilder 获得SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		//3. 这里有2个参数,第一个String 给他User对象对应的映射关系的xml,第二个参数给具体的参数
		//	第一个参数是 命名空间+id
		User user=session.selectOne("user.findById",3);
		session.close();
		System.out.println(user);
	}

	@Test
	//模糊查询
	public void firstDemo2() throws Exception{
		
		//1.通过SqlSessionFactoryBuilder 获得SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		//3. 这里有2个参数,第一个String 给他User对象对应的映射关系的xml,第二个参数给具体的参数
		//	第一个参数是 命名空间+id
		List<User> list=session.selectList("user.findByUsername","k");
		session.close();
	}
	
	@Test
	//添加功能
	public void addDemo() throws IOException{
		//1.通过SqlSessionFactoryBuilder 获得SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		//3. 这里有2个参数,第一个String 给他User对象对应的映射关系的xml,第二个参数给具体的参数
		//	第一个参数是 命名空间+id
		User user=new User();
		user.setUsername("你很厉害");
		user.setPassword("uuid123");
		
		UserMapper mapper=session.getMapper(UserMapper.class);
		mapper.insertUser(user);
		//事务提交
		session.commit();
	}
	
	@Test
	//添加功能
	/**
	 * 这里有个情景:
	 * 		我在插入用户后,我想使用他的id去生成一个购物订单(购物订单和用户的关联)
	 * 		那么此时我们在插入后能立马得到mysql自动生成的id,
	 * 		做法如下
	 * */
	public void addDemo2() throws IOException{
		//1.通过SqlSessionFactoryBuilder 获得SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		//3. 这里有2个参数,第一个String 给他User对象对应的映射关系的xml,第二个参数给具体的参数
		//	第一个参数是 命名空间+id
		User user=new User();
		user.setUsername("优越狗");
		user.setPassword("uuid123");
		user.setAddress("天津");
		
		session.insert("user.insertUser",user);
		//事务提交
		session.commit();
		System.out.println(user.getId());
	}
	

	@Test
	//修改功能
	public void updateDemo() throws IOException{
		//1.通过SqlSessionFactoryBuilder 获得SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		//3. 这里有2个参数,第一个String 给他User对象对应的映射关系的xml,第二个参数给具体的参数
		//	第一个参数是 命名空间+id
		User user=new User();
		user.setId(1);
		user.setUsername("黄焖鸡");
		user.setPassword("uuid123");
		user.setAddress("天津");
		
		session.update("user.update", user);
		//事务提交
		session.commit();
	}
	
	@Test
	//删除功能
	public void deleteDemo() throws IOException{
		//1.通过SqlSessionFactoryBuilder 获得SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		//3. 这里有2个参数,第一个String 给他User对象对应的映射关系的xml,第二个参数给具体的参数
		//	第一个参数是 命名空间+id
		session.delete("user.del",1);
		//事务提交
		session.commit();
	}
	
}