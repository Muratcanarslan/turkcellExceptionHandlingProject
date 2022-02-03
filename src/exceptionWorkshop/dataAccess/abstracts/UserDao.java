package exceptionWorkshop.dataAccess.abstracts;

import java.util.ArrayList;

import exceptionWorkshop.entities.concretes.User;

public interface UserDao {

	void login(String email, String password);

	void register(User user);

	ArrayList<User> getArrayList();

}
