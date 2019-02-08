import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table()
public class AcademicManager extends User{
private Cooperator cooperator;

@ManyToOne(optional=false)
public Cooperator getCooperator() {
   return this.cooperator;
}

public void setCooperator(Cooperator cooperator) {
   this.cooperator = cooperator;
}

private int academicManagerId;
   
   public void setAcademicManagerId(int value) {
this.academicManagerId = value;
    }
@Id
@GeneratedValue()public int getAcademicManagerId() {
return this.academicManagerId;
    }
public AcademicManager(String userEmail, String userPassword, String academicManagerName) {
	super(userEmail, userPassword, academicManagerName);
	// TODO Auto-generated constructor stub
}

}
