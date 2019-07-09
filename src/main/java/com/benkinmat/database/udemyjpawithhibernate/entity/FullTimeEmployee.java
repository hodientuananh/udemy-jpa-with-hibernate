package com.benkinmat.database.udemyjpawithhibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee{

	private BigDecimal salary;
	
	public FullTimeEmployee() {
		
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	public BigDecimal getHourlyWage() {
		return salary;
	}

	public void setHourlyWage(BigDecimal hourlyWage) {
		this.salary = hourlyWage;
	}

	@Override
	public String toString() {
		return "FullTimeEmployee [salary=" + salary + ", getName()=" + getName() + "]";
	}
	
}
