package tc.lv.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.Role;
import tc.lv.domain.User;
import tc.lv.exceptions.UserEntityServiceException;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger LOGGER = Logger
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public boolean createUser(String username, String firstname,
			String lastname, String email, String password)
			throws UserEntityServiceException {

		try {

			User tempUser = new User(username, firstname, lastname, email,
					password);

			if (userDao.findByName(username) == null) {
				Role role = userDao.findRoleByName("ROLE_USER");
				tempUser.addRoleToUser(role);
				userDao.save(tempUser);
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			LOGGER.error(e);
			throw new UserEntityServiceException("Could not create User", e);
		}

	}

	@Transactional
	@Override
	public boolean makeUserAdmin(String username)
			throws UserEntityServiceException {

		User user = userDao.findByName(username);

		try {

			if (user != null) {
				Role role = userDao.findRoleByName("ROLE_ADMIN");
				user.addRoleToUser(role);
				userDao.save(user);
				return true;

			} else {
				return false;
			}

		} catch (Exception e) {
			LOGGER.error(e);
			throw new UserEntityServiceException(
					"Could not give admin rights to user", e);
		}
	}
}
