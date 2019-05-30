package com.hzy.dao;

import java.util.List;

import com.hzy.pojo.User;

public interface UserMapper {

//	@Select("")
	List<User> getSearchUserListPage(String search);

}
