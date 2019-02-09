import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "USER")
public class User{
// TODO implement this operation
private int userId;
   
   public void setUserId(int value) {
this.userId = value;
    }
@Id
@GeneratedValue()public int getUserId() {
return this.userId;
    }
private Cooperator cooperator;

@ManyToOne(optional=false)
public Cooperator getCooperator() {
   return this.cooperator;
}

public void setCooperator(Cooperator cooperator) {
   this.cooperator = cooperator;
}

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
