package com.ims.database;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;
import com.ims.database.mybatis.DatabaseConnectionFactory;
import com.ims.database.mybatis.ImsMapper;
import com.ims.model.UserDetails;

/**
 * @author Anshika
 *
 */
@WebServlet("/databaseService")
public class DatabaseService extends HttpServlet {

	@Inject
	DatabaseConnectionFactory dbConnection;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try{
			Reader reader = Resources.getResourceAsReader("mybatisConnectionToSqlite.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			ImsMapper mapper= session.getMapper(ImsMapper.class);
			List<UserDetails> userDetails = mapper.getuserDetails(10001);
			UserDetails personData = new UserDetails();
			personData.setName(userDetails.get(0).getName());
			personData.setTelephone(userDetails.get(0).getTelephone());
			personData.setEmail(userDetails.get(0).getEmail());

			String json = new Gson().toJson(userDetails.get(0));
			response.setContentType("application/json");
			response.getWriter().write(json);
			System.out.println(userDetails.get(0).getName());

		}catch(IOException e){

		}
	}



}


