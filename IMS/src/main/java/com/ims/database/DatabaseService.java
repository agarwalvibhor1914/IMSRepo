package com.ims.database;

import java.io.BufferedReader;
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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
	private static final long serialVersionUID = 1L;

	public DatabaseService()
	{
		super();
	}

	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("inside database service");
		StringBuffer sb = new StringBuffer();

		try
		{
			BufferedReader reader = request.getReader();
			String line = null;
			while ((line = reader.readLine()) != null)
			{
				sb.append(line);
			}
		} catch (Exception e) { e.printStackTrace(); }

		JSONParser parser = new JSONParser();
		JSONObject joUser = null;
		try
		{
			joUser = (JSONObject) parser.parse(sb.toString());
		} catch (ParseException e) { e.printStackTrace(); }

		String id = (String) joUser.get("id");
		System.out.println("ID IS================"+id);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.write("A new user " + id + " has been created.");
		out.flush();
		out.close();
	}*/

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		try{
			System.out.println("this is for testing.");
			Reader reader = Resources.getResourceAsReader("mybatisConnectionToSqlite.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			ImsMapper mapper= session.getMapper(ImsMapper.class);

			StringBuffer sb = new StringBuffer();
			BufferedReader reader1 = request.getReader();
			String line = null;
			while ((line = reader1.readLine()) != null)
			{
				sb.append(line);
			}
			JSONParser parser = new JSONParser();
			JSONObject joUser = null;
			joUser = (JSONObject) parser.parse(sb.toString());

			String id = (String) joUser.get("id");
			String password = (String) joUser.get("password");

			System.out.println("password is============"+password);

			List<UserDetails> userDetails = mapper.getuserDetails(Integer.parseInt(id),password);
			String json = "";
			String msg = "INVALID ID....CAN'T LOGIN";
			if(userDetails.size()>0){
				json = new Gson().toJson(userDetails.get(0));
			}else{
				json=new Gson().toJson(msg);
			}



			reader.close();
			reader1.close();

			response.setContentType("application/json");
			response.getWriter().write(json);


		}catch(IOException e){

		}catch(ParseException e){

		}finally{

		}
	}



}


