package userService.serviceLayer;

import java.util.ArrayList;


import userService.dao.UserDAO;
import userService.vo.UserVO;

public class ServiceLayer {
	private static ServiceLayer serviceLayer = new ServiceLayer();
	
	private ServiceLayer() { }
	
	public UserDAO dao = UserDAO.getInstance();
	
	public static ServiceLayer getInstance() {
		return serviceLayer;
	}
	
	public boolean userInsert(UserVO user) {
		dao.userInsert(user);
		return true;
	}
	
	public ArrayList<UserVO> userList(){
		ArrayList<UserVO> list = dao.userList();
		return list;
	}
}
