package com.example.vehicleAuctionSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/emp")
public class empController {
	
@Autowired
empService empservice;

@GetMapping(value="/emps/{id}")
public emp getempById(@PathVariable("id") int id)
{ 
	System.out.println("From Database");
   emp e=empservice.getempById(id);

   return e;
}

@GetMapping(value="/emps")
public List<emp> getEmp()
{
	return empservice.getEmp();
}

@PostMapping(value="/emps/add")
public String addEmp(@RequestBody emp e)
{
	empservice.addEmpl(e);
	return "Added Succesfully";
}

@DeleteMapping(value="/emps/delete/{id}")
public String deleteEmp(@PathVariable ("id") int id)
{
	empservice.deleteById(id);
	return "Deleted Succesfully";
}

}
