/**
 *
 */
package com.ims.rest;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;
import com.ims.database.mybatis.ImsMapper;
import com.ims.model.UserDetails;

/**
 * @author Anshika
 *
 */
@Path("/userService")
public class UserService {

	@POST
	@Path("/varify")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response varifyUser(final UserDetails userDetails) {

		String json = "";
		boolean valid=false;
		try {
			Reader reader = Resources.getResourceAsReader("mybatisConnectionToSqlite.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			ImsMapper mapper = session.getMapper(ImsMapper.class);
			List<UserDetails> userDetailList = mapper.getuserDetails(userDetails.getId(),userDetails.getPassword());
			if (userDetailList.size() > 0) {
				json = new Gson().toJson(userDetailList.get(0));
				valid =true;
			} else {
				json = new Gson().toJson("INVALID ID....CAN'T LOGIN");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(valid){
			return Response.status(200).entity(json).build();
		}else{
			return Response.status(401).entity(json).build();
		}


	}

}
