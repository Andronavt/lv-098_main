package tc.lv.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tc.lv.domain.Role;
import tc.lv.domain.Source;
import tc.lv.domain.UserEntity;
import tc.lv.exceptions.DBCreateUserException;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext(name = "primary")
    private EntityManager entityManager;

    @Override
    public UserEntity loadByName(String name) {
	Query query = entityManager.createNamedQuery("UserEntity.loadByName",
		UserEntity.class).setParameter("username", name);
	UserEntity foundUser = (UserEntity) query.getSingleResult();
	return foundUser;
    }

    @Override
    public void createUser(UserEntity user) throws DBCreateUserException {
	// TODO Auto-generated method stub
	Query query = entityManager.createNamedQuery("UserEntity.loadByName",
		UserEntity.class);
	try {
	    query.setParameter("username", user.getUsername())
		    .getSingleResult();
	    throw new DBCreateUserException("That user is already exists");
	} catch (NoResultException e) {
	    Set<Role> roleSet = new HashSet<Role>();
	    Role role = new Role();
	    role = entityManager.find(Role.class, 2);
	    roleSet.add(role);
	    user.setRoleSet(roleSet);
	    entityManager.persist(user);
	}
    }

    @Override
    public void makeUserAdmin(UserEntity user) {
	Set<Role> roleSet = new HashSet<Role>();
	Role role = new Role();
	role = entityManager.find(Role.class, 1);
	roleSet.add(role);
	user.setRoleSet(roleSet);
	entityManager.persist(user);
    }

}
