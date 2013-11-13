package tc.lv.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tc.lv.domain.Role;
import tc.lv.domain.UserEntity;

//@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext(name = "primary")
	private EntityManager entityManager;

	@Deprecated
	public UserDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public UserEntity findByName(String name) {
		Query query = entityManager.createNamedQuery("UserEntity.findByName",
				UserEntity.class).setParameter("username", name);
		UserEntity foundUser;
		try {
			foundUser = (UserEntity) query.getSingleResult();
			return foundUser;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public void save(UserEntity user) {
		entityManager.persist(user);
	}

	@Override
	public void remove(UserEntity user) {
		user.getRoleSet().clear();
		entityManager.remove(user);
	}

	@Override
	public Role findRoleByName(String roleName) {
		Query query = entityManager.createNamedQuery("Role.findByName")
				.setParameter("roleName", roleName);
		Role role;
		try {
			role = (Role) query.getSingleResult();
			return role;
		} catch (NoResultException e) {
			return null;
		}
	}
}
