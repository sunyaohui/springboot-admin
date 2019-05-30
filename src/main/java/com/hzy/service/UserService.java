package com.hzy.service;

import com.hzy.pojo.User;
import com.hzy.pojo.page.Page;
import com.hzy.pojo.page.PageInfo;
import com.hzy.pojo.result.BaseVO;

public interface UserService {

	 public abstract PageInfo<User> getSearchUserListPage(String search, Page page);

	public abstract BaseVO addUser(User user);

	public abstract BaseVO updateUser(User user);

	public abstract BaseVO deleteUser(String id);

}
