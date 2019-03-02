package ca.mcgill.ecse321.cooperator.dto;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EmployerDto {
	private String email;
	private String password;
	private String name;
	private int coopUserId;
	private List<EventDto> event;
	private List<CoopTermDto> coopTerm;
	
	public EmployerDto() {
	}
	
	public EmployerDto(String email,String password, String name, int coopUserId) {
		this(email, password, name, coopUserId, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
	}
	
	public EmployerDto(String email, String password, String name, 
			int coopUserId, List<EventDto> event, List<CoopTermDto> coopTerm) {
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

	public List<EventDto> getEvent() {
		return event;
	}

	public List<CoopTermDto> getCoopTerm() {
		return coopTerm;
	}
}
