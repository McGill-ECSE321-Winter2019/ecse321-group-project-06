import javax.persistence.Entity;

@Entity
public abstract class User{
   private String email;

public void setEmail(String value) {
    this.email = value;
}
public String getEmail() {
    return this.email;
}
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
private String name;

public void setName(String value) {
    this.name = value;
}
public String getName() {
    return this.name;
}
   public User () {
      // TODO implement this operation
      throw new UnsupportedOperationException("not implemented");
   }
   
   }
