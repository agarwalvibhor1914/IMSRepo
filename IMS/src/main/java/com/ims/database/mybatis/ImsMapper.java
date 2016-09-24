package com.ims.database.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ImsMapper {
	List<String> getuserDetails(@Param("id") int id);
}
