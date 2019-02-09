import javax.persistence.ManyToOne;
import java.sql.Date;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
@Table()
public class Student extends User{
private Cooperator cooperator;

@ManyToOne(optional=false)
public Cooperator getCooperator() {
   return this.cooperator;
}

public void setCooperator(Cooperator cooperator) {
   this.cooperator = cooperator;
}

@Entity
public class Date{
}
private int studentId;
private String school;

private void setSchool(String value) {
this.school = value;
    }
private String getSchool() {
return this.school;
    }
private Date graduationDate;

private void setGraduationDate(Date value) {
this.graduationDate = value;
    }
private Date getGraduationDate() {
return this.graduationDate;
    }
private Set<CoopTerm> coopTerm;

@OneToMany(mappedBy="student")
public Set<CoopTerm> getCoopTerm() {
   return this.coopTerm;
}

public void setCoopTerm(Set<CoopTerm> coopTerms) {
   this.coopTerm = coopTerms;
}
public Student(String userEmail, String userPassword, String studentName, int studentId, String school, Date graduationDate) {
	super(userEmail, userPassword, studentName);
	// TODO Auto-generated constructor stub
	this.studentId = studentId;
	this.graduationDate = graduationDate;
	this.school = school;
}

}
