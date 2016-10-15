package com.ims.database.mybatis;

import javax.enterprise.context.ApplicationScoped;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@ApplicationScoped
public class DatabaseConnectionFactory {

	final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(DatabaseConnectionFactory.class.getResourceAsStream("mybatisConnectionToSqlite.xml"));

	public  SqlSession sessionProvider(){
		return sqlSessionFactory.openSession();
	}
}
