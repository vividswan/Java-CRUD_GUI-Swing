package userService.service;

import java.util.ArrayList;

import userService.dao.UserDAO;
import userService.vo.UserVO;

public class UserService {
	private static UserService service = new UserService();
	
	public UserDAO dao = UserDAO.getInstance();
	
	private UserService() {}
	private static UserService getInstance() {
		return service;
	}
	
	public boolean UserInsert(UserVO user) {
		dao.userInsert(user);
		return true;
	}
	
	public ArrayList<UserVO> userList(){
		ArrayList<UserVO> list = dao.userList();
		return list;
	}
}
