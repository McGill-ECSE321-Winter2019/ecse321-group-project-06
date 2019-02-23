package ca.mcgill.ecse321.cooperator.dto;

import java.util.Collections;
import java.util.List;


public class EmployerDto {
	
	private String companyName;
//	private String email;
//	private String password;
//	private int userId;  
	private List<CoopTermDto> coopTerms;

	public EmployerDto() {
	}

	@SuppressWarnings("unchecked")
	public EmployerDto(String name) {
		this(name, Collections.EMPTY_LIST);
	}

	public EmployerDto(String name, List<CoopTermDto> arrayList) {
		this.companyName = name;
		this.coopTerms = arrayList;
	}

	public String getName() {
		return companyName;
	}

	public List<CoopTermDto> getCoopTerms() {
		return coopTerms;
	}

}
