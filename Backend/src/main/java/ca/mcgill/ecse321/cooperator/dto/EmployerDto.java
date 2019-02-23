package ca.mcgill.ecse321.cooperator.dto;

import java.util.Collections;
import java.util.Set;

public class EmployerDto {
	private String email;
	private String password;
	private String name;
	private int coopUserId;
	private Set<EventDto> event;
	private Set<CoopTermDto> coopTerm;
	
	public EmployerDto() {
	}
	
	public EmployerDto(String email,String password, String name, int coopUserId) {
		this(email, password, name, coopUserId, Collections.EMPTY_SET, Collections.EMPTY_SET);
	}
	
	public EmployerDto(String email, String password, String name, 
			int coopUserId, Set<EventDto> event, Set<CoopTermDto> coopTerm) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.coopUserId = coopUserId;
		this.event = event;
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

	public Set<EventDto> getEvent() {
		return event;
	}

	public Set<CoopTermDto> getCoopTerm() {
		return coopTerm;
	}
}
