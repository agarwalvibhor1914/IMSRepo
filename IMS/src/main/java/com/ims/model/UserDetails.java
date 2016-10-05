/**
 *
 */
package com.ims.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Anshika
 *
 */
@XmlRootElement(name="UserDetails")
public class UserDetails {

	int id;
	String name;
	String password;
	String email;
	String telephone;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
}
