package com.crazybooks.biz;

import com.crazybooks.etity.Users;

public interface UserBiz {
	public String validateLogin(String userName, String password);
	public boolean validateRegister(String registerName);
	public void register(Users users);
}
