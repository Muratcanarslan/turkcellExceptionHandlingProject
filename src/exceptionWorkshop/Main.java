package exceptionWorkshop;

import exceptionWorkshop.business.concretes.UserManager;
import exceptionWorkshop.core.exceptions.BusinessException;
import exceptionWorkshop.dataAccess.concretes.HibernateUserDao;
import exceptionWorkshop.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User user1 = new User("murat", "arslan", "muratarslan97@outlook.com", "1234567");
		User user2 = new User("murat", "arslan", "muratarslan97@outlook.com", "1234123123");
		User user3 = new User();
		User user4 = new User("murat", "arslan", "muratarslan97outlook.com", "1234123123");
		User user5 = new User("murat", "arslan", "muratarslan97outlook.com", "123");

		UserManager userManager = new UserManager(new HibernateUserDao());

		// yeni bir kullanýcý eklemek
		try {
			userManager.register(user1);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		// olan kullanýcýyý eklemeye çalýþmak.
		try {
			userManager.register(user2);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		// alanlarý boþ olan bir kullanýcý eklemek
		try {
			userManager.register(user3);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		// kurallara uygun olmayan email
		try {
			userManager.register(user4);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		// kurallara uygun olmayan þifre
		try {
			userManager.register(user5);
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		// giriþ iþlemi
		try {
			userManager.login(user1.getEmail(), user1.getPassword());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

		// kayýtlý olmayan kullanýcý ile giriþ yapma iþlemi
		try {
			userManager.login("murat@gmail.com", user1.getPassword());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
		}

	}
}
