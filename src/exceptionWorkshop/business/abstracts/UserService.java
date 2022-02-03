package exceptionWorkshop.business.abstracts;

import exceptionWorkshop.core.exceptions.BusinessException;
import exceptionWorkshop.entities.concretes.User;

public interface UserService {

	void login(String email, String password) throws BusinessException;

	void register(User user) throws BusinessException;

}
