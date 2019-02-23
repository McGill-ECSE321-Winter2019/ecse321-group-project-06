package ca.mcgill.ecse321.cooperator.dto;

import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class StudentDto {

	private String email;
	private String password;
	private String name;
	private int coopUserId;
	private String school;
	private Date graduationDate;
	private Set<CoopTermDto> coopTerm;

	public StudentDto() {
	}
	
	public StudentDto(String email,String password, String name, int coopUserId) {
		this(email, password, name, coopUserId, Collections.EMPTY_SET);
	}
	
	public StudentDto(String email, String password, String name, 
			int coopUserId, Set<CoopTermDto> coopTerm) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.coopUserId = coopUserId;
		this.coopTerm = coopTerm;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public int getCoopUserId() {
		return coopUserId;
	}
	
	public String getSchool() {
		return this.school;
	}

	public Date getGraduationDate() {
		return this.graduationDate;
	}

	public Set<CoopTermDto> getCoopTerm() {
		return this.coopTerm;
	}


	
}
