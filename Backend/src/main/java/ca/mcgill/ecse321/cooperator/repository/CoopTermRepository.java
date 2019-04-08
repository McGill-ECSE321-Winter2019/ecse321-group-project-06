package ca.mcgill.ecse321.cooperator.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.CoopTerm;


public interface CoopTermRepository extends CrudRepository<CoopTerm, Integer> {
	/**
	 * get a coopterm by startDate
	 * @param startDate
	 * @return CoopTerm
	 */
	CoopTerm findByStartDate(Date startDate);
	/**
	 * get coopterm by endDate
	 * 
	 * @param endDate
	 * @return CoopTerm
	 */
	CoopTerm findByEndDate(Date endDate);
	/**
	 * get a coopterm by location
	 * 
	 * @param location
	 * @return
	 */
	CoopTerm findByLocation(String location);
	/**
	 * get a coopterm by academic semester
	 * 
	 * @param academicSemester
	 * @return CoopTerm
	 */
	CoopTerm findByAcademicSemester(String academicSemester);
	/**
	 * get a coopterm by id
	 * 
	 * @param id
	 * @return CoopTerm
	 */
	CoopTerm findById(int id);
}
