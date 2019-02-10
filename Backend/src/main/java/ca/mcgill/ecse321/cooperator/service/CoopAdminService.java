package ca.mcgill.ecse321.cooperator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.cooperator.entity.CoopAdmin;
import ca.mcgill.ecse321.cooperator.repository.CoopAdminRepository;

@Service
public class CoopAdminService {
	@Autowired
	CoopAdminRepository coopAdminRepository;
	
	@Transactional
	public CoopAdmin createCoopAdmin(String email, String password, String name){
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("name cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("email cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("password cannot be empty!");
		}
		CoopAdmin coopAdmin = new CoopAdmin();
		coopAdmin.setName(name);
		coopAdmin.setEmail(email);
		coopAdmin.setPassword(password);
		CoopAdmin coopAdminReturn = coopAdminRepository.save(coopAdmin);
		return coopAdminReturn;
	}
	
	@Transactional
	public CoopAdmin getCoopAdmin(int id){
		CoopAdmin coopAdmin = coopAdminRepository.findById(id).get();
		return coopAdmin;
	}
	
	@Transactional
	public List<CoopAdmin> getAllCoopAdmins() {
		return toList(coopAdminRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}