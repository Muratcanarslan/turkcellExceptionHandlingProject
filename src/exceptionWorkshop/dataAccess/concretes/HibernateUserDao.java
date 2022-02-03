package exceptionWorkshop.dataAccess.concretes;

import java.util.ArrayList;

import exceptionWorkshop.dataAccess.abstracts.UserDao;
import exceptionWorkshop.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	private ArrayList<User> userList;
	private int defaultId = 0;

	public HibernateUserDao() {
		userList = new ArrayList<User>();
	}

	@Override
	public void login(String email, String password) {
		System.out.println();
	}

	@Override
	public void register(User user) {
		user.setId(defaultId++);
		userList.add(user);
	}

	@Override
	public ArrayList<User> getArrayList() {
		return this.userList;
	}

}
