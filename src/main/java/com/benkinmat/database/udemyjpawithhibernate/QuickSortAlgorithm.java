package com.benkinmat.database.udemyjpawithhibernate;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class QuickSortAlgorithm implements Algorithm{

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		System.out.println("Quick Sort Algorithm");
	}
	
}
