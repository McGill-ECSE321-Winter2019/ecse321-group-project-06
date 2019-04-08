package ca.mcgill.ecse321.cooperator.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;


public interface CoopTermRepository extends CrudRepository<CoopTerm, Integer> {
	CoopTerm findByStartDate(Date startDate);
	CoopTerm findByEndDate(Date endDate);
	CoopTerm findByLocation(String location);
	CoopTerm findByAcademicSemester(String academicSemester);
	CoopTerm findById(int id);
}
