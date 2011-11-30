package org.oregami.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import org.oregami.keyobjects.KeyObjects.RoleKey;

@Entity
public class User extends BaseEntity {

	private static final long serialVersionUID = 4594670372719416989L;

	private String email;

	@Column(unique=true, nullable=false) 
	private String username;
	
	private String password;
	
	private String activationKey;
	
	private Timestamp registrationTime;
	
	@ElementCollection(targetClass=RoleKey.class)
	private List<RoleKey> roleList = new ArrayList<RoleKey>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public Timestamp getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Timestamp registrationTime) {
		this.registrationTime = registrationTime;
	}

	public List<RoleKey> getRollList() {
		return roleList;
	}

	public void setRollList(List<RoleKey> roleList) {
		this.roleList = roleList;
	}

	public boolean hasRole(RoleKey role) {
		return this.roleList.contains(role);
	}
	
}
