package ca.mcgill.ecse321.cooperator.entity;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="ACADEMICMANAGER")
public class AcademicManager extends User{
private int acdemicManagerId;
   
   public void setAcdemicManagerId(int value) {
this.acdemicManagerId = value;
    }
@Id
public int getAcdemicManagerId() {
return this.acdemicManagerId;
    }
public AcademicManager(String userEmail, String userPassword, String acManagerName) {
	super(userEmail, userPassword, acManagerName);
	// TODO Auto-generated constructor stub
}

}
