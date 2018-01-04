package com.jit.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.jit.mapper.DepartmentMapper;
import com.jit.mapper.PersonCardMapper;
import com.jit.mapper.UserMapper;
import com.jit.model.Department;
import com.jit.model.PersonCard;
import com.jit.model.QueryVo;
import com.jit.model.Staff;
import com.jit.model.User;


public class MapperDemo {

	@Test
	public void test1() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.findById(1);
		System.out.println(user.getUsername());
	}
	
	@Test
	//妯＄硦鏌ヨ
	public void test2() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list=mapper.findByUsername("k");
		System.out.println();
	}
	
	@Test
	//鎻掑叆
	public void test3() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		User user=new User();
		user.setUsername("榛勭剸楦�");
		user.setPassword("uuid123");
		user.setAddress("澶╂触");
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.insertUser(user);
		session.commit();
	}
	
	@Test
	//鐢ㄨ繃pojo鍖呰绫讳紶閫掑弬鏁�
	public void test4() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		QueryVo vo=new QueryVo();
		
		User user=new User();
		user.setUsername("k");
		vo.setUser(user);
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.findByName(vo);
		System.out.println();
	}
	
	@Test
	//缁熻鎬绘暟
	public void test5() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		int totalCount = mapper.totalCount();
		System.out.println(totalCount);
	}
	
	@Test
	//鍔ㄦ�sql
	//if
	public void test6() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setUsername("jkh");
//		user.setPassword("123");
		List<User> list = mapper.findByNamePass(user);
		for (User user2 : list) {
			System.out.println(user2.getUsername());
		}
	}
	
/*	@Test
	//鍔ㄦ�sql
	//foreach
	public void test7() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		QueryVo vo=new QueryVo();
		List<Integer> list=new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(3);
		vo.setIdsList(list);
		List<User> list2 = mapper.findByIds(list);
		for (User user2 : list2) {
			System.out.println(user2.getUsername());
		}
	}*/
	
	@Test
	//鍔ㄦ�sql
	//foreach
	public void test8() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		int[] arr={2,3,4};
		List<User> list2 = mapper.findByIds(arr);
		for (User user2 : list2) {
			System.out.println(user2.getUsername());
		}
	}
	
	@Test
	//鐢ˊParam娉ㄨВ鏉ヤ紶鍏ュ涓弬鏁�
	public void test9() throws IOException{
		//1.閫氳繃SqlSessionFactoryBuilder 鑾峰緱SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.閫氳繃sessionFactoy 鑾峰緱 session
		SqlSession session = sqlSessionFactory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		QueryVo vo=new QueryVo();
		User user=new User();
		user.setPassword("321");
		user.setUsername("mmp");
		vo.setUser(user);
		
		User user2 = mapper.findByMap(vo);
		System.out.println(user2);
	}
	
	@Test
	// 1:1 连着关联类一起查询
	public void test10() throws IOException{
		//1通过SqlSessionFactoryBuilder 创建SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		
		PersonCardMapper mapper = session.getMapper(PersonCardMapper.class);
		
		List<PersonCard> list= mapper.findById();
		System.out.println(list);
	}
	
	@Test
	// 1:n 连着关联类一起查询
	public void test11() throws IOException{
		//1通过SqlSessionFactoryBuilder 创建SqlSessionFactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//2.通过sessionFactoy 获得 session
		SqlSession session = sqlSessionFactory.openSession();
		
		DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
		Department d = mapper.findById(3);
		Set<Staff> ss=d.getSet();
		for(Staff s1:ss){
			System.out.println(s1);
		}
	}
}
