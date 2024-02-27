package com.example.vehicleAuctionSystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class empService {
@Autowired
EmpRepository repo;

public emp getempById(int id)
{
	
	return repo.findById(id).get();

}
public List<emp> getEmp()
{
	
	List<emp> emps = new ArrayList<emp>();  
	repo.findAll().forEach(emp-> emps.add(emp));  
	
	return emps;  
}
public void addEmpl(emp e)
{
	repo.save(e);
}

public void deleteById(int id)
{
	repo.deleteById(id);
}
}