package com.crazybooks.biz.impl;

import java.util.List;

import net.sf.json.JSONObject;

import com.crazybooks.base.AdminDao;
import com.crazybooks.base.impl.AdminDaoImpl;
import com.crazybooks.biz.AdminBiz;
import com.crazybooks.etity.Managers;
import com.crazybooks.etity.Users;

public class AdminBizImpl implements AdminBiz{

	private AdminDao adi;
	
	@Override
	public JSONObject AdminLogin(Managers manager) {
		// TODO Auto-generated method stub
		adi=new AdminDaoImpl();
		return adi.AdminLogin(manager);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		adi=new AdminDaoImpl();
		return adi.getAllUsers();
	}

}