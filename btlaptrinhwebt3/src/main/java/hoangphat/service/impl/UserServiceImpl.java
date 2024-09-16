package hoangphat.service.impl;

import dao.IUserModel;
import dao.impl.UserDaoImpl;
import hoangphat.service.IUserService;
import models.UserModel;

public class UserServiceImpl implements IUserService{
	
	IUserModel userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public boolean register(String email, String password, String username, String fullname, String phone) {
		if (this.checkExistUsername(username)) {
			return false;
			}
			long millis=System.currentTimeMillis();
			java.sql.Date date=new java.sql.Date(millis);
			userDao.insert(new UserModel(0, username, email, password, fullname, null, phone, 1, date));
			return true;
	}	

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistUsername(phone);
	}
	
}
