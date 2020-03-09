package com.crudOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AppController 
{
	@Autowired
	private StudentServices studentServices;
	
	@RequestMapping("/")
	public String viewHomePage(Model model)
	{
	    List<Student> listStudents = studentServices.listAll();
	    model.addAttribute("listStudents", listStudents);
	     
	    return "index";
	}
	
	@RequestMapping("/new")
	public String showNewStudentPage(Model model) {
	    Student student = new Student();
	    model.addAttribute("student", student);
	     
	    return "addStudent";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentServices.save(student);
	     
	    return "redirect:/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		studentServices.delete(id);
	    return "redirect:/";        
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("editStudent");
	    Student student = studentServices.get(id);
	    mav.addObject("student", student);
	     
	    return mav;
	}
}
