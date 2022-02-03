package exceptionWorkshop.business.concretes;

import exceptionWorkshop.business.abstracts.UserService;
import exceptionWorkshop.core.exceptions.BusinessException;
import exceptionWorkshop.core.regex.EmailRegex;
import exceptionWorkshop.dataAccess.abstracts.UserDao;
import exceptionWorkshop.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void login(String email, String password) throws BusinessException {
		if (checkIfEmailIsValid(email)) {
			checkIfLoginDataIsValid(email, password);
		}
	}

	@Override
	public void register(User user) throws BusinessException {
		if (checkIfFieldsIsNull(user) && checkIfPasswordIsValid(user.getPassword())
				&& checkIfEmailIsValid(user.getEmail()) && checkIfUserAlreadyExist(user)) {
			userDao.register(user);
		}
	}

	public boolean checkIfFieldsIsNull(User user) throws BusinessException {
		if (user.getEmail() == null || user.getPassword() == null || user.getLastName() == null
				|| user.getName() == null) {
			throw new BusinessException("Alanlar boþ olamaz");
		} else {
			return true;
		}
	}

	public boolean checkIfPasswordIsValid(String password) throws BusinessException {
		if (password.length() < 6) {
			throw new BusinessException("Þifre 6 karakterden küçük olamaz");
		} else {
			return true;
		}
	}

	public boolean checkIfEmailIsValid(String email) throws BusinessException {
		if (!EmailRegex.validate(email)) {
			throw new BusinessException("Email kurallara uygun deðil");
		} else {
			return true;
		}
	}

	public boolean checkIfUserAlreadyExist(User user) throws BusinessException {
		for (User temp : userDao.getArrayList()) {
			if (temp.getEmail() == user.getEmail()) {
				throw new BusinessException("böyle bir kullanýcý var");
			}
		}

		return true;
	}

	public void checkIfLoginDataIsValid(String email, String password) throws BusinessException {
		for (User user : userDao.getArrayList()) {
			if (user.getEmail() == email && user.getPassword() == password) {
				System.out.println("giriþ baþarýlý");
				return;
			}
		}
		throw new BusinessException("Bilgileriniz Yanlýþ");
	}

}
