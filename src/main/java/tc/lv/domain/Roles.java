package tc.lv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@Column(name = "role_id", nullable = false)
	private int id;
	@Column(name = "role", nullable = false)
	private String role;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "role")
	private UserDB userDB;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDB getUser() {
		return userDB;
	}

	public void setUser(UserDB userDB) {
		this.userDB = userDB;
	}

	Roles() {

	}
}
