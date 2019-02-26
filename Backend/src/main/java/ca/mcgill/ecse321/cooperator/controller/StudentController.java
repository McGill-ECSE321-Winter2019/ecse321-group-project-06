package ca.mcgill.ecse321.cooperator.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.CoopTermDto;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.service.CoopTermService;



@CrossOrigin(origins = "*")
@RestController
public class StudentListController {

	@GetMapping(value = { "/events", "/events/" })
	public List<CoopTermDto> getAllCoopTerms() {
		CoopTermService service = new CoopTermService();
		List<CoopTermDto> coopTermDtos = new ArrayList<>();
		for (CoopTerm coopTerm : service.getAllCoopTerms()) {
			//coopTermDtos.add(convertToDto(coopTerm));
		}
		return coopTermDtos;
	}
	
//	private CoopTermDto convertToDto(CoopTerm e) {
//		if (e == null) {
//			throw new IllegalArgumentException("There is no such Coop term!");
//		}
//		CoopTermDto coopTermDto = new CoopTermDto(e.getEndDate(), e.getStartDate(), e.getLocation(),e.getAcademicSemester(),
//				e.isIfWorkPermitNeeded(), e.getJobDescription(), e.getEvaluationForm(), e.getCoopPlacement(),
//				e.getTaxCreditForm(), e.getEmployer());
//		
//		return coopTermDto;
//	}
	//only get all coop term for this specific employer 
}
