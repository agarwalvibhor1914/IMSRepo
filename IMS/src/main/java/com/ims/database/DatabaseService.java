package com.ims.database;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ims.database.mybatis.ImsMapper;

/**
 * @author Anshika
 *
 */
@WebServlet("/databaseService")
public class DatabaseService extends HttpServlet {
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException {
		try{
			Reader reader = Resources.getResourceAsReader("mybatisConnectionToSqlite.xml");
		     SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
		     SqlSession session = sqlSessionFactory.openSession();
		     
		     ImsMapper mapper= session.getMapper(ImsMapper.class);
		     List<String> userDetails = mapper.getuserDetails(10001);
		     
		     System.out.println("this is for testng.");
		     
		}catch(IOException e){
			
		}
	}
	
}

	
