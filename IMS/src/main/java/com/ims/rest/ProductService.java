package com.ims.rest;

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
import com.ims.model.ProductDetails;

@Path("/productService")
public class ProductService {

	@POST
	@Path("/productDetails")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getproductDetails() {

		String json = "";
		boolean valid=false;
		try {
			Reader reader = Resources.getResourceAsReader("mybatisConnectionToSqlite.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			SqlSession session = sqlSessionFactory.openSession();
			ImsMapper mapper = session.getMapper(ImsMapper.class);
			List<ProductDetails> productDetailList = mapper.getproductDetails();
			if (productDetailList.size() > 0) {
				json = new Gson().toJson(productDetailList.get(0));
				valid =true;
			} else {
				json = new Gson().toJson("NO PRODUCTS FOUND");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(valid){
			return Response.status(200).entity(json).build();
		}else{
			return Response.status(401).entity(json).build();
		}


	}
}
