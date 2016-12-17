package com.ims.database.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ims.model.ProductDetails;
import com.ims.model.UserDetails;

public interface ImsMapper {
	List<UserDetails> getuserDetails(@Param("id") int id,@Param("password") String password);
	List<ProductDetails> getproductDetails();
}
