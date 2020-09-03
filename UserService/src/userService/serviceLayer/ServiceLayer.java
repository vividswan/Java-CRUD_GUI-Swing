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
	
	public String[][] userList(){
		String[][] list = dao.userList();
		return list;
	}
	
	public String[][] findByName(String name){
		String[][] list = dao.findByName(name);
		return list;
	}
	
	public boolean update(int id, String number) {
		dao.update(id, number);
		return true;
	}
	
	public boolean delete(int id) {
		dao.delete(id);
		return true;
	}
}
