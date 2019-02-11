package ca.mcgill.ecse321.cooperator.repository;

import java.sql.Date;


import org.springframework.data.repository.CrudRepository;


import ca.mcgill.ecse321.cooperator.entity.CoopAdmin;
import ca.mcgill.ecse321.cooperator.entity.CoopTerm;
import ca.mcgill.ecse321.cooperator.entity.Employer;
import ca.mcgill.ecse321.cooperator.entity.Student;


public interface CoopTermRepository extends CrudRepository<CoopTerm, Integer> {
	

		//public CoopTerm createCoopTerm(String location, Date startDate, String academicSemester, boolean ifWorkPermitNeeded,String jobDescription, Student student, Employer employer, CoopAdmin coopAdmin, int coopTermId, Date endDate);

	
		//public CoopTerm getCoopTerm( int coopTermId) ;
}
