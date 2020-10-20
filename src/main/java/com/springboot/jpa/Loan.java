package com.springboot.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

import io.swagger.annotations.ApiModelProperty;

@Component

//Spring jpa jars.
@Entity
@Table(name= "loan_table")

@DynamicInsert
@DynamicUpdate
public class Loan {
	@ApiModelProperty(notes = "Loan Number",name="loanNumber",required=true,value="1111")
	@Id
	@Column(name="loan_number")
	private int loanNumber;
	@ApiModelProperty(notes = "Name of the borrower",name="borrowerName",required=true,value="test borrow")
	@Column(name="borrower_name")
    private String borrowerName;
	@ApiModelProperty(notes = "Borrrower's date of birth",name="dob",required=true,value="10-20-1990")
	@Column(name="dob")
    private Date dob;
	@ApiModelProperty(notes = "Address that is being purchased",name="propertyAddress",required=true,value="101 any st, anytown 55555")
	@Column(name="property_address")
    private String propertyAddress;
	@ApiModelProperty(notes = "Price of the property",name="cost",required=true,value="100000")
	@Column(name="cost")
    private int cost;
	@ApiModelProperty(notes = "Indicator of whether there is a flood risk",name="floodRisk",required=true,value="Yes")
	@Column(name="flood_risk")
    private String floodRisk;
	
    public Loan() {
    	
    }
    
    public Loan(int loanNumber, String borrowerName, Date dob, String propertyAddress, int cost, String floodRisk) {
        this.loanNumber=loanNumber;
        this.borrowerName=borrowerName;
        this.dob=dob;
        this.propertyAddress=propertyAddress;
        this.cost=cost;
        this.floodRisk=floodRisk;
    }
    
    public int getLoanNumber() {
		return loanNumber;
	}
	public void setLoanNumber(int loanNumber) {
		this.loanNumber = loanNumber;
	}
	public String getBorrowerName() {
		return borrowerName;
	}
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getFloodRisk() {
		return floodRisk;
	}
	public void setFloodRisk(String floodRisk) {
		this.floodRisk = floodRisk;
	}
	
	@Override
	public String toString() {
		return "Loan [" + "loanNumber=" + loanNumber + ", borrowerName=" + borrowerName + ", dob=" + dob + ", propertyAddress=" + propertyAddress + ", cost=" + cost + ", floodRisk=" + floodRisk +  "]";
	}
}
