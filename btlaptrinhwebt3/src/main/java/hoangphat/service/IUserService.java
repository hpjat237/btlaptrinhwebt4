package hoangphat.service;

import hoangphat.models.UserModel;

public interface IUserService {

		UserModel login(String username, String password);
		UserModel findByUsername(String username);
		boolean checkExistUsername(String username);
		boolean checkExistPhone(String phone);
		boolean register(String email, String password, String username, String fullname, String phone);
		boolean checkExistEmail(String email);
		void insert(UserModel user);
}
