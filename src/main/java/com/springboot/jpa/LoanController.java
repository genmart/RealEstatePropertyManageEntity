package com.springboot.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = {"${cors.url}"})
//@CrossOrigin
@Api(value = "LoanController", description = "REST Apis related to Loan Entity!!!!")
//@Transactional( propagation = Propagation.REQUIRED)
public class LoanController {

	  @Autowired
	  private LoanDao loanDao;
	  
	  @Autowired
	  private Environment env;
	  
	  
	  @RequestMapping(value="/add/loan", method=RequestMethod.POST)
	  @ResponseBody
	  public String create(@RequestBody Loan loan, HttpServletResponse response) {
		//response.addHeader("Access-Control-Allow-Origin", "*");
		//System.out.println(response.getHeaderNames().toString() + ": " + response.getHeader("Access-Control-Allow-Origin"));
	    try {
	      loanDao.create(loan);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return "Loan succesfully added!";
	  }
	  
	  @ApiOperation(value = "Add all loans from one source ", response = Iterable.class, tags = "createAll")
	  @RequestMapping(value="/add/loanList", method=RequestMethod.POST)
	  @ResponseBody
	  public String createAll(@RequestBody List<Loan> loanList,HttpServletResponse response) {
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/plain");
		System.out.println(response.getHeaderNames().toString() +" -> Access-Control-Allow-Origin"+ ": " + response.getHeader("Access-Control-Allow-Origin"));
		System.out.println("response content type: "+response.getContentType());
		for(Loan loan:loanList)
			System.out.println(loan);
		int recordCount = loanList.size();
		try {
	      loanDao.createAll(loanList);
	    }
	    catch (Exception ex) {
	      return ex.getMessage();
	    }
	    return "Successfully inserted rows into the database!\nRecords Inserted= "+recordCount;
	  }
	  
	  @RequestMapping(value="/get/loan")
	  @ResponseBody
	  public Loan getLoan(HttpServletResponse response, @PathVariable int id) {
		response.setContentType("JSON");
		System.out.println(response.getHeaderNames().toString() + ": " + response.getHeader("Access-Control-Allow-Origin"));
		Loan loan = new Loan();
		try {
	      loan = loanDao.getLoan(id);
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return loan;
	  }
	  
	  @ApiOperation(value = "Get list of all loans from the database ", response = Iterable.class, tags = "getLoans")
	  @RequestMapping(value="/get/loanList", method=RequestMethod.GET)
	  @ResponseBody
	  public List<Loan> getLoans(HttpServletResponse response) {
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("JSON");
		System.out.println(response.getHeaderNames().toString() +" -> Access-Control-Allow-Origin"+ ": " + response.getHeader("Access-Control-Allow-Origin"));
		System.out.println("response content type: "+response.getContentType());
		List<Loan> loanList = new ArrayList <Loan>();
		for(Loan loan:loanList)
			System.out.println(loan);
		try {
	      loanList = loanDao.getLoans();
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	    }
	    return loanList;
	  }
}
