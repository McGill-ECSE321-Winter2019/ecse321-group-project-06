package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "USER")
public class User{
// TODO implement this operation
public User(String email, String password, String name) {
	this.email = email;
	this.password = password;
	this.name = name;
}

private String email;
   
   private void setEmail(String value) {
this.email = value;
    }
private String getEmail() {
return this.email;
    }
private String password;

private void setPassword(String value) {
this.password = value;
    }
private String getPassword() {
return this.password;
    }
private String name;

private void setName(String value) {
this.name = value;
    }
private String getName() {
return this.name;
    }

}
