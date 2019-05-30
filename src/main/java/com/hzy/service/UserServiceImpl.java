package com.hzy.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.hzy.pojo.User;
import com.hzy.pojo.page.Page;
import com.hzy.pojo.page.PageInfo;
import com.hzy.pojo.result.BaseVO;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public PageInfo<User> getSearchUserListPage(String search, Page page) {
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
//		List<User> list = userMapper.getSearchUserListPage(search);
        return new PageInfo<User>(new ArrayList<User>());
	}

	@Override
	public BaseVO addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseVO updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseVO deleteUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
