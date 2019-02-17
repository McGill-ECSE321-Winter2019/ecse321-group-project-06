package ca.mcgill.ecse321.cooperator.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.cooperator.entity.Employer;

public interface EmployerRepository extends CrudRepository<Employer, Integer> {
	Employer findByName(String name);
}
