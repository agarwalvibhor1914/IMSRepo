package com.ims.database.mybatis;

import java.io.IOException;
import java.io.Reader;

import javax.enterprise.context.ApplicationScoped;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@ApplicationScoped
public class DatabaseConnectionFactory {

	public SqlSession sessionProvider() throws IOException{
		Reader reader = Resources.getResourceAsReader("mybatisConnectionToSqlite.xml");
	    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
	    SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
}
