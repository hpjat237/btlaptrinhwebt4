package hoangphat.service.impl;

import hoangphat.dao.IUserModel;
import hoangphat.dao.impl.UserDaoImpl;
import hoangphat.models.UserModel;
import hoangphat.service.IUserService;

public class UserServiceImpl implements IUserService{
	
	IUserModel userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
	        System.out.println("LOGIN SUCCESS");
	        System.out.println(user.getUsername());
	        System.out.println(user.getPassword());
			return user;
		}
        System.out.println("LOGIN ERROR");
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
			userDao.insert(new UserModel(0, username, email, password, fullname, null, phone, 3, date));
	        System.out.println(new UserModel(0, username, email, password, fullname, null, phone, 3, date));
	        System.out.println("REGISTER SUCCESS");
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
	
	public static void main(String[] args) {
        // Tạo đối tượng UserServiceImpl để gọi các phương thức
        UserServiceImpl userService = new UserServiceImpl();
        
        // Thử đăng ký một người dùng
        String username = "testuser";
        String email = "testuser@example.com";
        String password = "password123";
        String fullname = "Test User";
        String phone = "0123456789";
        
        // Gọi phương thức đăng ký
        boolean registrationResult = userService.register(email, password, username, fullname, phone);
        System.out.println("Registration result: " + (registrationResult ? "Success" : "Failed"));
        
        // Thử đăng nhập với người dùng đã đăng ký
        UserModel user = userService.login(username, password);
        if (user != null) {
            System.out.println("Login successful: " + user);
        } else {
            System.out.println("Login failed");
        }
        
        // Thử đăng nhập với thông tin không chính xác
        UserModel failedLogin = userService.login(username, "wrongpassword");
        if (failedLogin != null) {
            System.out.println("Login successful: " + failedLogin);
        } else {
            System.out.println("Login failed with incorrect password");
        }
    }
	
}
